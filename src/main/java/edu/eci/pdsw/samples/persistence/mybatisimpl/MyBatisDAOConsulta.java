/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public class MyBatisDAOConsulta implements DaoConsulta {
    @Inject
    ConsultaMapper consultaMapper;
    
    @Override
    public Consulta load(int id) throws PersistenceException {
        return consultaMapper.getConsulta(id);
       }
    @Override
    public List<Consulta> loadAll() throws PersistenceException {
       return consultaMapper.getConsultas();
    }

    @Override
    public void save(Consulta c) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
