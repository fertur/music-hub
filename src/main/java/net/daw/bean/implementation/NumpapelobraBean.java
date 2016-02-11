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
import net.daw.dao.implementation.NumpapelDao;
import net.daw.dao.implementation.ObraDao;
import net.daw.dao.implementation.TipodocumentoDao;
import net.daw.dao.implementation.UsuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class NumpapelobraBean implements GenericBean {

    @Expose
    private Integer id;    
    @Expose(serialize = false)
    private Integer id_obra = 0;
    @Expose(deserialize = false)
    private ObraBean obj_obra = null;
    @Expose(serialize = false)
    private Integer id_numpapel = 0;
    @Expose(deserialize = false)
    private NumpapelBean obj_numpapel = null;

    public NumpapelobraBean() {
        this.id = 0;
    }

    public NumpapelobraBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId_numpapel() {
        return id_numpapel;
    }

    public void setId_numpapel(Integer id_numpapel) {
        this.id_numpapel = id_numpapel;
    }

    public NumpapelBean getObj_numpapel() {
        return obj_numpapel;
    }

    public void setObj_numpapel(NumpapelBean obj_numpapel) {
        this.obj_numpapel = obj_numpapel;
    }

   

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "id_obra,";
        strColumns += "id_numpapel";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += id_obra + ",";
        strColumns += id_numpapel;
        return strColumns;
    }

    @Override
    public String toPairs() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "id_obra=" + id_obra + ",";
        strPairs += "id_numpapel=" + id_numpapel;
        return strPairs;
    }

    @Override
    public NumpapelobraBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));             
        if (expand > 0) {
            ObraBean oObraBean = new ObraBean();
            ObraDao oObraDao = new ObraDao(pooledConnection);
            oObraBean.setId(oResultSet.getInt("id_obra"));
            oObraBean = oObraDao.get(oObraBean, expand - 1);
            this.setObj_obra(oObraBean);
        } else {
            this.setId_obra(oResultSet.getInt("id_obra"));
        }
        
        if (expand > 0) {
            NumpapelBean oNumpapelBean = new NumpapelBean();
            NumpapelDao oNumpapelDao = new NumpapelDao(pooledConnection);
            oNumpapelBean.setId(oResultSet.getInt("id_numpapel"));
            oNumpapelBean = oNumpapelDao.get(oNumpapelBean, expand - 1);
            this.setObj_numpapel(oNumpapelBean);
        } else {
            this.setId_numpapel(oResultSet.getInt("id_numpapel"));
        }
        return this;
    }

}
