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
import net.daw.dao.implementation.GeneroDao;
import net.daw.dao.implementation.InstrumentoDao;
import net.daw.dao.implementation.NumpapelDao;
import net.daw.dao.implementation.TipoobraDao;
import net.daw.dao.implementation.TonalidadobraDao;
import net.daw.dao.implementation.UsuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class ObraBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose
    private String titulo = "";
    @Expose
    private String descripcion = "";
    @Expose
    private Date fecha_subida = new Date();
    @Expose
    private Date fecha_modificacion = new Date();
    @Expose
    private Integer visitas = 0;
    @Expose
    private Integer valoracion;
    @Expose
    private Boolean destacado = false;
    @Expose(serialize = false)
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    private UsuarioBean obj_usuario = null;
    @Expose(serialize = false)
    private Integer id_tonalidadobra = 0;
    @Expose(deserialize = false)
    private TonalidadobraBean obj_tonalidadobra = null;
//    @Expose(serialize = false)
//    private Integer id_generoobra = 0;
//    @Expose(deserialize = false)
//    private GeneroobraBean obj_generoobra = null;
    @Expose(serialize = false)
    private Integer id_genero = 0;
    @Expose(deserialize = false)
    private GeneroBean obj_genero = null;
//    @Expose(serialize = false)
//    private Integer id_categoria = 0;
//    @Expose(deserialize = false)
//    private UsuarioBean obj_categoria = null;
    @Expose(serialize = false)
    private Integer id_instrumento = 0;
    @Expose(deserialize = false)
    private InstrumentoBean obj_instrumento = null;
    @Expose(serialize = false)
    private Integer id_numpapel = 0;
    @Expose(deserialize = false)
    private NumpapelBean obj_numpapel = null;
    @Expose(serialize = false)
    private Integer id_tipoobra = 0;
    @Expose(deserialize = false)
    private TipoobraBean obj_tipoobra = null;
    

    public ObraBean() {
        this.id = 0;
    }

    public ObraBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(Date fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(Boolean destacado) {
        this.destacado = destacado;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioBean getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(UsuarioBean obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

    public Integer getId_tonalidadobra() {
        return id_tonalidadobra;
    }

    public void setId_tonalidadobra(Integer id_tonalidadobra) {
        this.id_tonalidadobra = id_tonalidadobra;
    }

    public TonalidadobraBean getObj_tonalidadobra() {
        return obj_tonalidadobra;
    }

    public void setObj_tonalidadobra(TonalidadobraBean obj_tonalidadobra) {
        this.obj_tonalidadobra = obj_tonalidadobra;
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

    public Integer getId_instrumento() {
        return id_instrumento;
    }

    public void setId_instrumento(Integer id_instrumento) {
        this.id_instrumento = id_instrumento;
    }

    public InstrumentoBean getObj_instrumento() {
        return obj_instrumento;
    }

    public void setObj_instrumento(InstrumentoBean obj_instrumento) {
        this.obj_instrumento = obj_instrumento;
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

    public Integer getId_tipoobra() {
        return id_tipoobra;
    }

    public void setId_tipoobra(Integer id_tipoobra) {
        this.id_tipoobra = id_tipoobra;
    }

    public TipoobraBean getObj_tipoobra() {
        return obj_tipoobra;
    }

    public void setObj_tipoobra(TipoobraBean obj_tipoobra) {
        this.obj_tipoobra = obj_tipoobra;
    }
    
    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "titulo,";
        strColumns += "descripcion,";
        strColumns += "fecha_subida,";
        strColumns += "fecha_modificacion,";
        strColumns += "visitas,";
        strColumns += "valoracion,";
        strColumns += "destacado,";
        strColumns += "id_usuario,";
        strColumns += "id_tonalidadobra,";
        strColumns += "id_genero,";
        strColumns += "id_instrumento,";
        strColumns += "id_numpapel,";
        strColumns += "id_tipoobra";
        return strColumns;
    }

    public String toJson(Boolean expand) {
        String strJson = "{";
        strJson += "id:" + id + ",";
        strJson += "titulo:" + EncodingUtilHelper.quotate(titulo) + ",";
        strJson += "descripcion:" + EncodingUtilHelper.quotate(descripcion) + ",";
        strJson += "fecha_subida:" + EncodingUtilHelper.stringifyAndQuotate(fecha_subida) + ",";
        strJson += "fecha_modificacion:" + EncodingUtilHelper.stringifyAndQuotate(fecha_modificacion) + ",";
        strJson += "visitas:" + visitas + ",";
        strJson += "valoracion:" + valoracion + ",";
        strJson += "destacado:" + destacado + ",";

        if (expand) {
            strJson += "obj_usuario:" + obj_usuario.toJson(false) + ",";
            strJson += "obj_tonalidadobra:" + obj_tonalidadobra.toJson(false) + ",";
            strJson += "obj_genero:" + obj_genero.toJson(false) + ",";
            strJson += "obj_instrumento:" + obj_instrumento.toJson(false) + ",";
            strJson += "obj_numpapel:" + obj_numpapel.toJson(false) + ",";
            strJson += "obj_tipoobra:" + obj_tipoobra.toJson(false) + ",";
        } else {
            strJson += "id_usuario:" + id_usuario + ",";
            strJson += "id_tonalidadobra:" + id_tonalidadobra + ",";
            strJson += "id_genero:" + id_genero + ",";
            strJson += "id_instrumento:" + id_instrumento + ",";
            strJson += "id_numpapel:" + id_numpapel + ",";
            strJson += "id_tipoobra:" + id_tipoobra;
        }
        strJson += "}";
        return strJson;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(titulo) + ",";
        strColumns += EncodingUtilHelper.quotate(descripcion) + ",";
        strColumns += EncodingUtilHelper.stringifyAndQuotate(fecha_subida) + ",";
        strColumns += EncodingUtilHelper.stringifyAndQuotate(fecha_modificacion) + ",";
        strColumns += visitas + ",";
        strColumns += valoracion + ",";
        strColumns += destacado + ",";
        strColumns += id_usuario + ",";
        strColumns += id_tonalidadobra + ",";
//        strColumns += id_generoobra + ",";
        strColumns += id_genero + ",";
        //  strColumns += id_tipousuario;
        strColumns += id_instrumento + ",";
        strColumns += id_numpapel + ",";
        strColumns += id_tipoobra;
        return strColumns;
    }

    @Override
    public String toPairs() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strPairs = "";
        //strPairs += "id=" + id + ",";
        strPairs += "titulo=" + EncodingUtilHelper.quotate(titulo) + ",";
        strPairs += "descripcion=" + EncodingUtilHelper.quotate(descripcion) + ",";
        strPairs += "fecha_subida=" + EncodingUtilHelper.quotate(format.format(fecha_subida)) + ",";
        strPairs += "fecha_modificacion=" + EncodingUtilHelper.quotate(format.format(fecha_modificacion)) + ",";
        strPairs += "visitas=" + visitas + ",";
        strPairs += "valoracion=" + valoracion + ",";
        strPairs += "destacado=" + destacado + ",";
        strPairs += "id_usuario=" + id_usuario + ",";
        strPairs += "id_tonalidadobra=" + id_tonalidadobra + ",";
        strPairs += "id_genero=" + id_genero + ",";
        strPairs += "id_instrumento=" + id_instrumento + ",";
        strPairs += "id_numpapel=" + id_numpapel + ",";
        strPairs += "id_tipoobra=" + id_tipoobra;
        return strPairs;
    }

    @Override
    public ObraBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setTitulo(oResultSet.getString("titulo"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        this.setFecha_subida(oResultSet.getDate("fecha_subida"));
        this.setFecha_modificacion(oResultSet.getDate("fecha_modificacion"));
        this.setVisitas(oResultSet.getInt("visitas"));
        this.setValoracion(oResultSet.getInt("valoracion"));
        this.setDestacado(oResultSet.getBoolean("destacado"));

        if (expand > 0) {
            UsuarioBean oUsuarioBean = new UsuarioBean();
            UsuarioDao oUsuarioDao = new UsuarioDao(pooledConnection);
            oUsuarioBean.setId(oResultSet.getInt("id_usuario"));
            oUsuarioBean = oUsuarioDao.get(oUsuarioBean, expand - 1);
            this.setObj_usuario(oUsuarioBean);
        } else {
            this.setId_usuario(oResultSet.getInt("id_usuario"));
        }

        if (expand > 0) {
            TonalidadobraBean oTonalidadobraBean = new TonalidadobraBean();
            TonalidadobraDao oTonalidadobraDao = new TonalidadobraDao(pooledConnection);
            oTonalidadobraBean.setId(oResultSet.getInt("id_tonalidadobra"));
            oTonalidadobraBean = oTonalidadobraDao.get(oTonalidadobraBean, expand - 1);
            this.setObj_tonalidadobra(oTonalidadobraBean);
        } else {
            this.setId_tonalidadobra(oResultSet.getInt("id_tonalidadobra"));
        }

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
            InstrumentoBean oInstrumentoBean = new InstrumentoBean();
            InstrumentoDao oInstrumentoDao = new InstrumentoDao(pooledConnection);
            oInstrumentoBean.setId(oResultSet.getInt("id_instrumento"));
            oInstrumentoBean = oInstrumentoDao.get(oInstrumentoBean, expand - 1);
            this.setObj_instrumento(oInstrumentoBean);
        } else {
            this.setId_instrumento(oResultSet.getInt("id_instrumento"));
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
        
        if (expand > 0) {
            TipoobraBean oTipoobraBean = new TipoobraBean();
            TipoobraDao oTipoobraDao = new TipoobraDao(pooledConnection);
            oTipoobraBean.setId(oResultSet.getInt("id_tipoobra"));
            oTipoobraBean = oTipoobraDao.get(oTipoobraBean, expand - 1);
            this.setObj_tipoobra(oTipoobraBean);
        } else {
            this.setId_tipoobra(oResultSet.getInt("id_tipoobra"));
        }

        return this;
    }

}
