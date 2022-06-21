package fr.dauphine.miageIf.msa.MSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ChangeController {

  // Spring se charge de la création d'instance
  @Autowired
  private Environment environment;

  // Spring se charge de la création d'instance
  @Autowired
  private TauxChangeRepository repository;

  @GetMapping("/devise-change/source/{source}/dest/{dest}")
  public TauxChange retrouveTauxChange
    (@PathVariable String source, @PathVariable String dest){

    TauxChange tauxChange =
        repository.findBySourceAndDest(source, dest);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/
    
    return tauxChange;
  }

}