package sm.apirest.tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sm.apirest.tareas.models.Tarea;
import sm.apirest.tareas.repo.TareaRepository;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("")
    List<Tarea> index(){
        return tareaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Tarea created (@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping("{id}")
    Tarea update(@PathVariable String id, @RequestBody Tarea tarea){
        //Obtener tarea actualizar
        Tarea tareaDB = tareaRepository.findById(id).orElseThrow(RuntimeException::new);

        //Asignar nuevos valores
        tareaDB.setNombre( tarea.getNombre() );
        tareaDB.setStatus( tarea.getStatus() );

        //Almacenar nuevos datos en el documento
        return tareaRepository.save(tareaDB);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        //Obtener variable a eliminar
        Tarea tareaDB = tareaRepository.findById(id).orElseThrow(RuntimeException::new);
        //Eliminar Documento
        tareaRepository.delete(tareaDB);
    }

}
