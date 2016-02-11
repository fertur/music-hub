/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.daw.bean.implementation;

import net.daw.bean.publicinterface.GenericBean;
import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.daw.dao.implementation.GeneroDao;
import net.daw.dao.implementation.ObraDao;

public class GeneroobraBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose(serialize = false)
    private Integer id_genero = 0;
    @Expose(deserialize = false)
    private GeneroBean obj_genero = null;   
    @Expose(serialize = false)
    private Integer id_obra = 0;
    @Expose(deserialize = false)
    private ObraBean obj_obra = null;
    
    public GeneroobraBean() {
        this.id = 0;
    }

    public GeneroobraBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public GeneroBean getObj_genero() {
        return obj_genero;
    }

    public void setObj_genero(GeneroBean obj_genero) {
        this.obj_genero = obj_genero;
    }

    public Integer getId_obra() {
        return id_obra;
    }

    public void setId_obra(Integer id_obra) {
        this.id_obra = id_obra;
    }

    public ObraBean getObj_obra() {
        return obj_obra;
    }

    public void setObj_obra(ObraBean obj_obra) {
        this.obj_obra = obj_obra;
    }    

    public String toJson(Boolean expand) {
        String strJson = "{";
        strJson += "id:" + id + ","; 
        strJson += "id_genero:" + id_genero + ",";
        strJson += "id_obra:" + id_obra;
        strJson += "}";
        return strJson;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "id_genero,";
        strColumns += "id_obra";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";    
        strColumns += id_genero + ","; 
        strColumns += id_obra; 
        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "id=" + id + ",";  
        strPairs += "id=" + id_genero + ",";
        strPairs += "id=" + id_obra;
        return strPairs;
    }

    @Override
    public GeneroobraBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id")); 
        if (expand > 0) {
            GeneroBean oGeneroBean = new GeneroBean();
            GeneroDao oGeneroDao = new GeneroDao(pooledConnection);
            oGeneroBean.setId(oResultSet.getInt("id_genero"));
            oGeneroBean = oGeneroDao.get(oGeneroBean, expand - 1);
            this.setObj_genero(oGeneroBean);
        } else {
            this.setId_genero(oResultSet.getInt("id_genero"));
        }  
        
        if (expand > 0) {
            ObraBean oObraBean = new ObraBean();
            ObraDao oObraDao = new ObraDao(pooledConnection);
            oObraBean.setId(oResultSet.getInt("id_obra"));
            oObraBean = oObraDao.get(oObraBean, expand - 1);
            this.setObj_obra(oObraBean);
        } else {
            this.setId_obra(oResultSet.getInt("id_obra"));
        } 
        return this;

    }

}
