package space.bum.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

  @GetMapping("/showViewPage")
  public String sendParameterWithModel(Model model) {
    var map = new HashMap<String, String>();
    map.put("name", "구름이");
    model.addAttribute("weight", 11.4);
    model.mergeAttributes(map);
    return "view/viewPage";
  }
  
  @GetMapping("/getThruMap")
  public String sendParameterWithModelMap(ModelMap map) {
    map.put("name", "구름이");
    map.addAttribute("weight", 11.5);
    return "view/viewPage";
  }
  
  @GetMapping("/getModelView")
  public ModelAndView sendThruModelAndView() {
    ModelAndView view = new ModelAndView("view/viewPage");
    var map = new HashMap<String, String>();
    map.put("name", "구름이");
    
    view.addAllObjects(map);
    view.addObject("weight", 10.9);
    return view;
  }
}
