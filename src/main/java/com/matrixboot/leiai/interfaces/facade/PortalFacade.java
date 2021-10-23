//package com.matrixboot.leiai.interfaces.facade;
//
//import com.matrixboot.leiai.application.service.PortalService;
//import com.matrixboot.leiai.interfaces.dto.ResultVO;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 门户首页
// * <p>
// * create in 2021/10/23 2:13 下午
// *
// * @author shishaodong
// * @version 0.0.1
// */
//@AllArgsConstructor
//@RestController
//@RequestMapping("portal")
//public class PortalFacade {
//
//    private final PortalService portalService;
//
//    /**
//     * 获取所有的用户数量
//     *
//     * @return Long
//     */
//    @GetMapping("user/count")
//    ResultVO<Long> userCount() {
//        return ResultVO.success(portalService.countUsers());
//    }
//
//
//}
