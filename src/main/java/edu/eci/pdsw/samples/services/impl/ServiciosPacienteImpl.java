/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacienteImpl implements ServiciosPaciente {

    @Inject
    private DaoPaciente daoPaciente;
    @Inject
    private DaoConsulta daoConsulta;

    @Override
    public List<Paciente> consultarPacientes() throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Paciente consultarPacientesPorId(int id, TipoIdentificacion tipoIdentificacion) throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.load(id,tipoIdentificacion);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Paciente> consultarMenoresConEnfermedadContagiosa() throws ExcepcionServiciosSuscripciones {
        List<Paciente> pacientes =consultarPacientes();
        List<Paciente> resp=new ArrayList<Paciente>();
        try{
            for (Paciente p : pacientes ){
                if (p.getTipo_id().equals(TipoIdentificacion.TI)){
                    List<Consulta> consultas=p.getConsultas();
                    for (Consulta c : consultas){
                        if (c.getResumen().contains("varicela")) {
                             resp.add(p);
                    }
                        } 
                }
            }
        }catch(Exception e){
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+e.getLocalizedMessage(), e);
        }
        return resp;
    }


    
    
}
