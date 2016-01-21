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
import net.daw.dao.implementation.TipousuarioDao;
import net.daw.dao.implementation.UsuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class ObraBean implements GenericBean {

    @Expose
    private Integer id;
    @Expose
    private String titulo = "";
    @Expose
    private String contenido = "";
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
   /* @Expose(serialize = false)
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    private TipousuarioBean obj_tipousuario = null;*/
//    @Expose(serialize = false)
//    private Integer id_categoria = 0;
//    @Expose(deserialize = false)
//    private UsuarioBean obj_categoria = null;

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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

   
    
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "titulo,";
        strColumns += "contenido,";
        strColumns += "fecha_subida,";
        strColumns += "fecha_modificacion,";
        strColumns += "visitas,";        
        strColumns += "valoracion,";        
        strColumns += "destacado,";
        strColumns += "id_usuario";
        return strColumns;
    }
    
    public String toJson(Boolean expand) {
        String strJson = "{";
        strJson += "id:" + id + ",";
        strJson += "titulo:" + EncodingUtilHelper.quotate(titulo) + ",";
        strJson += "contenido:" + EncodingUtilHelper.quotate(contenido) + ",";
        strJson += "fecha_subida:" + fecha_subida + ",";
        strJson += "fecha_modificacion:" + fecha_modificacion + ",";
        strJson += "visitas:" + visitas + ",";
        strJson += "valoracion:" + valoracion + ",";
        strJson += "destacado:" + destacado + ",";
        
        if (expand) {            
            strJson += "obj_usuario:" + obj_usuario.toJson(false) + ",";
          //  strJson += "obj_tipousuario:" + obj_tipousuario.toJson(false) + ",";
        } else {            
            strJson += "id_usuario:" + id_usuario + ",";
         //   strJson += "id_tipousuario:" + id_tipousuario;
        }
        strJson += "}";
        return strJson;
    }

    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(titulo) + ",";
        strColumns += EncodingUtilHelper.quotate(contenido) + ",";
        strColumns += EncodingUtilHelper.stringifyAndQuotate(fecha_subida) + ",";
        strColumns += EncodingUtilHelper.stringifyAndQuotate(fecha_modificacion) + ",";
        strColumns += visitas + ",";        
        strColumns += valoracion + ",";       
        strColumns += destacado + ",";
        strColumns += id_usuario;
      //  strColumns += id_tipousuario;
        return strColumns;
    }

    @Override
    public String toPairs() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        String strPairs = "";
        //strPairs += "id=" + id + ",";
        strPairs += "titulo=" + EncodingUtilHelper.quotate(titulo) + ",";
        strPairs += "contenido=" +  EncodingUtilHelper.quotate(contenido) + ",";
        strPairs += "fecha_subida=" + EncodingUtilHelper.quotate(format.format(fecha_subida)) + ",";
        strPairs += "fecha_modificacion=" + EncodingUtilHelper.quotate(format.format(fecha_modificacion)) + ",";
        strPairs += "visitas=" + visitas + ",";
        strPairs += "valoracion=" +  valoracion + ",";        
        strPairs += "destacado=" + destacado + ",";
        strPairs += "id_usuario=" + id_usuario;
      //  strPairs += "id_tipousuario=" + id_tipousuario;
        return strPairs;
    }

    @Override
    public ObraBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setTitulo(oResultSet.getString("titulo"));
        this.setContenido(oResultSet.getString("contenido"));
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
        return this;
    }

}
