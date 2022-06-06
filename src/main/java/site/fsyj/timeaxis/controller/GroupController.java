package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fsyj.timeaxis.dto.EventDto;
import site.fsyj.timeaxis.service.EventService;
import site.fsyj.timeaxis.service.GroupService;

import javax.annotation.Resource;

@Api("群组模块")
@RestController
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupService groupServiceImpl;

    @Resource
    private EventService eventServiceImpl;

    @ApiOperation("加入群组")
    @PostMapping("/join/{userId}/{groupname}")
    public ResponseEntity<String> joinGroup(@PathVariable String userId, @PathVariable String groupname) {
        try {
            groupServiceImpl.join(userId, groupname);
            return ResponseEntity.ok("加入成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation("创建群组")
    @PostMapping("/create/{userid}")
    public ResponseEntity<String> addGroup(@PathVariable String userid, @RequestBody String groupName) {
        groupServiceImpl.createGroup(userid, groupName);
        return ResponseEntity.ok("创建成功");
    }

    @ApiOperation("添加群组事件")
    @PostMapping("/addevent/{userid}/{groupid}")
    public ResponseEntity<String> addEvent(@PathVariable String userid, @PathVariable String groupid, @RequestBody EventDto groupEvent) {
        eventServiceImpl.addGroupEvent(userid, groupid, groupEvent);
        return ResponseEntity.ok("添加成功");
    }
}
