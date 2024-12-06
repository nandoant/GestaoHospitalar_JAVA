package gestaohospitalar;

import gestaohospitalar.model.Medico;
import java.util.List;


public class GestaoMedico {
    private List<Medico> medicos;

    public GestaoMedico(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    
    
}
