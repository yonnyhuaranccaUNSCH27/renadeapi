package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.MenuDTO;
import ipd.renade.renadeapi.service.IMenuService;
import ipd.renade.renadeapi.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuController {
    private final IMenuService menuService;
    private final MapperUtil mapperUtil;

    @PostMapping("/usuario")
    public ResponseEntity<List<MenuDTO>> getMenusByUsuario(@RequestBody String username) {
        System.out.println("username = " + username);
        List<MenuDTO> menusDTO=mapperUtil.mapList(menuService.getMenuByUsername(username),MenuDTO.class);
        System.out.println("menusDTO = " + menusDTO);
        return ResponseEntity.ok(menusDTO);

    }

}
