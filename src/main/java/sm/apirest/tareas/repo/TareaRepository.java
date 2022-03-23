package sm.apirest.tareas.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import sm.apirest.tareas.models.Tarea;

//Documento y tipo de Identificador
public interface TareaRepository extends MongoRepository<Tarea, String> {
}
