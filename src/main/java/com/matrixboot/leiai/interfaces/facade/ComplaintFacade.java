package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/10/23 2:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@RestController
public class ComplaintFacade {

    private final ComplaintService complaintService;

}
