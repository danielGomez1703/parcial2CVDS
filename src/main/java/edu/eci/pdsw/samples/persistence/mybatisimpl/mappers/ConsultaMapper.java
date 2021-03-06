/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Jairo Gomez
 */
public interface ConsultaMapper {
        public List<Consulta> getConsultas();
        public Consulta getConsulta(@Param("cId") int id);
}
