/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import javax.enterprise.context.SessionScoped;
import java.sql.Date;;


/**
 *
 * @author Jairo Gomez
 */
@ManagedBean(name="pacientebean")
@SessionScoped
public class PacienteConBean extends BasePageBean{
    private List<Paciente> pacientes = new ArrayList<>(); 
    @Inject
    private ServiciosPaciente serviciosPaciente;
    private TipoIdentificacion actTipoIdentificacion;
    private int actualId;


    
    public void home(){
        try{
            pacientes=serviciosPaciente.consultarPacientes();   
        }catch(ExcepcionServiciosSuscripciones e){
             Logger.getLogger(PacienteConBean.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    
    public Paciente consultarPaciente (int id) {
        Paciente paciente=null;
        try{
            for (Paciente p : pacientes){
                if (p.getId()==id)
                    paciente=p;
            }
        }catch(Exception e){
             Logger.getLogger(PacienteConBean.class.getName()).log(Level.SEVERE, null,e);
        }
        return paciente;
    }
    
        public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ServiciosPaciente getServiciosPaciente() {
        return serviciosPaciente;
    }

    public void setServiciosPaciente(ServiciosPaciente serviciosPaciente) {
        this.serviciosPaciente = serviciosPaciente;
    }

    public TipoIdentificacion getActTipoIdentificacion() {
        return actTipoIdentificacion;
    }

    public void setActTipoIdentificacion(TipoIdentificacion actTipoIdentificacion) {
        this.actTipoIdentificacion = actTipoIdentificacion;
    }

    public int getActualId() {
        return actualId;
    }

    public void setActualId(int actualId) {
        this.actualId = actualId;
    }


}