package com.hidalgosoft.municipios.configuration;

public class ConstantQuery {
    public  static final String OBTENER_MENU="select " +
            "ts.clave as Clave_Tipo_Servicio" +
            ",ts.nombre as Tipo_Servicio" +
            ",ic.codigo as Clave_Servicio " +
            ",ic.nombre as Servicio " +
            ",ic.descripcion as Cobertura " +
            ",ic.prioridad" +
            ",ic.id as id_servicio" +
            ",ts.id as id_tipoServicio " +
            "from cat_tipo_servicio ts " +
            "inner join incidente ic on ts.id = ic.tipo_servicio_id " +
            "order by ts.clave,ic.prioridad;";
}
