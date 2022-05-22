package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fsyj.timeaxis.entity.Event;
import site.fsyj.timeaxis.service.EventService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fsyj on 2022/5/22
 */
@Slf4j
@Api("事件管理模块")
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventServiceImpl;

    @ApiOperation("添加事件")
    @PostMapping("/add")
    public ResponseEntity<String> createEvent(@RequestBody String name, @RequestBody String teacher,
                                              @RequestBody String major, @RequestBody String time, HttpServletRequest request) {
        String userid = (String) request.getAttribute("userId");
        Event event = new Event();
        event.setName(name);
        event.setTeacher(teacher);
        event.setTime(time);
        event.setMajor(major);
        event.setOwner(Integer.valueOf(userid));
        eventServiceImpl.insert(event);
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation("查询所有的事件")
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(HttpServletRequest request) {
        String userid = (String) request.getAttribute("userId");
        List<Event> events = eventServiceImpl.selectAll(userid);
        return ResponseEntity.ok(events);
    }

    @ApiOperation("删除事件")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable String eventId) {
        eventServiceImpl.deleteByPrimaryKey(Integer.valueOf(eventId));
        return ResponseEntity.ok("删除成功");
    }

}
