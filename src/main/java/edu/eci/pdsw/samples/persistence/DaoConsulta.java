/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public interface DaoConsulta {
    
    public Consulta load(int id) throws PersistenceException;
    
    public List<Consulta> loadAll() throws PersistenceException;
    
    public void save(Consulta c) throws PersistenceException;
}
