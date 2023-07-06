package com.teamd.tt.todolist;

import com.teamd.tt.todolist.model.dto.*;
import com.teamd.tt.todolist.model.vo.SelRegionAllVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Todolist 지역 목록")
    public SelRegionAllVo getRegion() {
        return service.selRegion();
    }

    @PostMapping
    @Operation(summary = "여행정보 추가",
            description = "<h3>idRegion : 시,도 고유값\n" +
                    "<h3>idRegionDetail : 군,구 고유값\n" +
                    "<h3>startDate : 시작 날짜 0000-00-00\n" +
                    "<h3>endDate : 마지막 날짜 0000-00-00\n" +
                    "<h3>calColor : 색깔코드\n " +
                    "<h3>subTitle : 여행일정 내용\n" +
                    "<h3>checkList : 체크리스트 내용\n")
    public int postAddTitle(@RequestBody InsDto dto) {
        return service.insTravelInfo(dto);
    }

    @DeleteMapping("/delete/check/{idCheck}")
    public int delCheckList(@PathVariable int idCheck) {
        DelCheckListDto dto = new DelCheckListDto();
        dto.setIdCheck(idCheck);
        return service.delCheckList(dto);
    }

    @DeleteMapping("/delete/sub/{idSub}")
    public int delSubTitle(@PathVariable int idSub) {
        DelSubTitleDto dto = new DelSubTitleDto();
        dto.setIdSub(idSub);
        return service.delSubTitle(dto);
    }

    @PatchMapping("/delete/{idTitle}")
    public int patchTravel(@PathVariable int idTitle) {
        UpdTravelDto dto = new UpdTravelDto();
        dto.setIdTitle(idTitle);
        return service.updTravel(dto);
    }

//    @PutMapping("/{idTitle}")
//    @Operation(summary = "여행지 수정",
//            description = "<h3>idRegion : 시,도 고유값\n" +
//                    "<h3>idRegionDetail : 군,구 고유값\n" +
//                    "<h3>startDate : 시작 날짜 0000-00-00\n" +
//                    "<h3>endDate : 마지막 날짜 0000-00-00\n" +
//                    "<h3>calColor : 색깔코드\n" +
//                    "<h3>idTitle : 여행지pk 값\n")
//    public int putTitle(@PathVariable int idTitle, @RequestBody updTitleDto dto) {
//        updTitleEntity entity = new updTitleEntity();
//        entity.setIdTitle(idTitle);
//        entity.setIdRegion(dto.getIdRegion());
//        entity.setIdRegionDetail(dto.getIdRegionDetail());
//        entity.setStartDate(dto.getStartDate());
//        entity.setEndDate(dto.getEndDate());
//        entity.setCalColor(dto.getCalColor());
//        return service.updTitle(entity);
//    }
//    @PutMapping("/sub/{idSub}")
//    @Operation(summary = "여행일정 수정")
//    public int putSubTitle(@PathVariable int idSub, @RequestBody updSubTitleDto dto) {
//        updSubTitleEntity entity = new updSubTitleEntity();
//        entity.setIdSub(idSub);
//        entity.setSubTitle(dto.getSubTitle());
//        entity.setIdTitle(dto.getIdTitle());
//        return service.updSubTitle(entity);
//
//    }


}