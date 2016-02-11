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
import java.text.SimpleDateFormat;
import java.util.Date;
import net.daw.dao.implementation.GrupoinstrumentoDao;
import net.daw.dao.implementation.TipodocumentoDao;
import net.daw.dao.implementation.UsuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class InstrumentoBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose
    private String nombre = "";    
    @Expose(serialize = false)
    private Integer id_grupoinstrumento = 0;
    @Expose(deserialize = false)
    private GrupoinstrumentoBean obj_grupoinstrumento = null;

    public InstrumentoBean() {
        this.id = 0;
    }

    public InstrumentoBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_grupoinstrumento() {
        return id_grupoinstrumento;
    }

    public void setId_grupoinstrumento(Integer id_grupoinstrumento) {
        this.id_grupoinstrumento = id_grupoinstrumento;
    }

    public GrupoinstrumentoBean getObj_grupoinstrumento() {
        return obj_grupoinstrumento;
    }

    public void setObj_grupoinstrumento(GrupoinstrumentoBean obj_grupoinstrumento) {
        this.obj_grupoinstrumento = obj_grupoinstrumento;
    }
    
    public String toJson(Boolean expand) {
        String strJson = "{";
        strJson += "id:" + id + ",";
        strJson += "nombre:" + nombre + ",";
        strJson += "id_grupoinstrumento:" + id_grupoinstrumento;
        strJson += "}";
        return strJson;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "nombre,";        
        strColumns += "id_grupoinstrumento";       
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(nombre) + ",";       
        strColumns += id_grupoinstrumento;        
        return strColumns;
    }

    @Override
    public String toPairs() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "nombre=" + EncodingUtilHelper.quotate(nombre) + ",";       
        strPairs += "id_grupoinstrumento=" + id_grupoinstrumento;       
        return strPairs;
    }

    @Override
    public InstrumentoBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setNombre(oResultSet.getString("nombre"));        
        if (expand > 0) {
            GrupoinstrumentoBean oGrupoinstrumentoBean = new GrupoinstrumentoBean();
            GrupoinstrumentoDao oGrupoinstrumentoDao = new GrupoinstrumentoDao(pooledConnection);
            oGrupoinstrumentoBean.setId(oResultSet.getInt("id_grupoinstrumento"));
            oGrupoinstrumentoBean = oGrupoinstrumentoDao.get(oGrupoinstrumentoBean, expand - 1);
            this.setObj_grupoinstrumento(oGrupoinstrumentoBean);
        } else {
            this.setId_grupoinstrumento(oResultSet.getInt("id_grupoinstrumento"));
        }
        
        return this;
    }

    

}
