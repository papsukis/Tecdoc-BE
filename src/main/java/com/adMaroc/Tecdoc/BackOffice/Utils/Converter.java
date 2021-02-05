package com.adMaroc.Tecdoc.BackOffice.Utils;

import com.adMaroc.Tecdoc.BackOffice.Models.Attributs;
import com.adMaroc.Tecdoc.BackOffice.Models.FileStructure;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Constructor;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class Converter {

    private static Object convert(String type, String s,String atriName) {
        if(atriName.contains("loschFlag") &&  s.contains("i")){
            return 0;
        }
        if (type.contains("N") && s.trim().isEmpty()) {
            return 0;
        }
        if (type.contains("N") && s.contains(".")) {
            return Float.parseFloat(s);
        }
        if ((type .contains("C") || type .contains("U") )) {
            return s.trim();
        }
        if (type.contains("N")) {
            return Long.parseLong(s.trim());
        }
        return s.trim();
    }

    public Object instantiate(FileStructure fileStructure,String line) throws Exception {
        // Load the class.
        Class<?> clazz = Class.forName("com.adMaroc.Tecdoc.BackOffice.Models.TecdocData."+fileStructure.getClassName());

        Object obj = clazz.newInstance();
        for(Attributs at : fileStructure.getAttr()){
            if(isPrimaryKey(getPrimaryKeys(fileStructure),at.getName()) && getPrimaryKeys(fileStructure).size()>1){
                Object id= Class.forName("com.adMaroc.Tecdoc.BackOffice.Models.TecdocData.compositeKeys."+fileStructure.getClassName()+"Id").newInstance();
                PropertyUtils.setProperty(id,at.getName(),convert(at.getType(),line.substring(at.getPos(),at.getPos()+at.getLength()),at.getName()));
                PropertyUtils.setNestedProperty(obj,"id",id);
            }
            else if(!at.getName().contains("Reserviert") && !at.getName().contains("reserved")){
            PropertyUtils.setProperty(obj, at.getName(), convert(at.getType(),line.substring(at.getPos(),at.getPos()+at.getLength()),at.getName()));
            }
        }
        log.info(obj.toString());
        return obj;
    }

    private List<String> getPrimaryKeys(FileStructure f){
        List< String> tmp=new ArrayList<>();
        if(f.getPrimaryKey()!=null)
        tmp = Arrays.asList(f.getPrimaryKey().split(","));
        return tmp;
    }
    private boolean isPrimaryKey(List<String> primaryKeys,String attribute){
        return primaryKeys.contains(attribute);
    }
}
