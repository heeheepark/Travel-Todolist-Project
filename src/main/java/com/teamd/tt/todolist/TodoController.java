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
            description =
                    "<h3>idRegionDetail : 군,구 고유값 (다섯자리 번호)\n" +
                    "<h3>idRegion : 시,도 고유값 (두자리 번호)\n" +
                    "<h3>startDate : 시작 날짜 0000-00-00\n" +
                    "<h3>endDate : 마지막 날짜 0000-00-00\n" +
                    "<h3>calColor : 색깔코드\n " +
                    "<h3>subTitle : 여행일정 내용\n" +
                    "<h3>checkList : 체크리스트 내용\n" +
                    "<h3>-----------------------\n" +
                    "<h3>code 0 : 저장 성공\n" +
                    "<h3>code 1 : travel 테이블 정보저장 실패\n" +
                    "<h3>code 2 : sub_title 테이블 정보저장 실패\n" +
                    "<h3>code 3 : check_list 테이블 정보저장 실패\n")
    public int postTravelInfo(@RequestBody InsDto dto) throws Exception {
        return service.insTravelInfo(dto);
    }

    @GetMapping("/{idTitle}")
    @Operation(summary = "여행정보 조회",
            description = "<h3> idTitle : 여행 pk값")
    public SelPickInfo getPickInfo (@PathVariable int idTitle) {
        return service.selPickInfo(idTitle);
    }

    @DeleteMapping("/check/{idCheck}")
    @Operation(summary = "체크리스트 삭제",
            description =
                    "<h3>idCheck : 체크리스트 pk값\n ")
    public int delCheckList(@PathVariable int idCheck) {
        DelCheckListDto dto = new DelCheckListDto();
        dto.setIdCheck(idCheck);
        return service.delCheckList(dto);
    }

    @DeleteMapping("/sub/{idSub}")
    @Operation(summary = "여행일정(+체크리스트) 삭제",
            description =
                    "<h3>idSub : 여행일정 pk값\n")
    public int delSubTitle(@PathVariable int idSub) {
        DelSubTitleDto dto = new DelSubTitleDto();
        dto.setIdSub(idSub);
        return service.delSubTitle(dto);
    }
    @PatchMapping("/{idTitle}")
    @Operation(summary = "여행지 삭제",
            description =
                    "<h3>idTitle : 여행지 pk값\n")
    public int patchTravel(@PathVariable int idTitle) {
        UpdTravelDto dto = new UpdTravelDto();
        dto.setIdTitle(idTitle);
        return service.updTravel(dto);
    }
    @PutMapping("/{idTitle}")
    @Operation(summary = "여행정보 수정")
    public int putPickInfo(@PathVariable int idTitle, @RequestBody ModifyPickInfo pickInfo) {
        pickInfo.setIdTitle(idTitle);
        return service.updPickInfo(pickInfo);
    }
}