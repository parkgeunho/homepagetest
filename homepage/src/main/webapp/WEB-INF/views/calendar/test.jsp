<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link rel="stylesheet" href="/portfolio/resources/FullCalendar/fullcalendar.css">

<script src="/portfolio/resources/FullCalendar/moment.min.js"></script>
<script src="/portfolio/resources/FullCalendar/fullcalendar.js"></script>
</head>
<script type="text/javascript">




$(document).ready(function() {

    // page is now ready, initialize the calendar...
    var test = '${test}';
    var ck = JSON.parse(test);
    
    $('#calendar').fullCalendar({
        // put your options and callbacks here
            header: {
		        left: 'prev,next,prevYear,nextYear today ',
		        center: 'title',
		        right: 'month,agendaWeek,agendaDay'
		    }, 
		    events: [
		        {
		            title  : 'event1',
		            start  : '2010-01-01'
		        },
		        {
		            title  : 'event2',
		            start  : '2010-01-05',
		            end    : '2010-01-07'
		        },
		        {
		            title  : 'event3',
		            start  : '2017-03-29T13:30:00',
		            allDay : false // will make the time show
		        }
		    ],


        
		eventColor: 'rgba(55,128,6,0.7)',

	    defaultView: 'month',
	    
	    views: {
	    	month: {
	        	
	            titleFormat: 'YYYY MMM'
	        }
	    },
	    
	    eventLimit: true,
	    
	    views: {
	        agenda: {
	            eventLimit: 6
	        }
	    },
	    
	    timezone: 'local',
	    
	    allDaySlot: false,
	    
	    slotLabelFormat: 'HH:mm',
	    
	    scrollTime: '00:00:00',
	    
	    slotEventOverlap: true,
	    
	    nowIndicator: true,
	         
		timeFormat: 'HH:mm',
		
		/* timeFormat: 'YYYY-MM-DD-HH-mm', */
		
		displayEventTime: true,
		
		selectable: true,
		
		unselectAuto: true,
		
		/* selectOverlap: true, */
		
		eventTextColor: '#FFFFD2',
		
		editable: true,
		
		select: function(start, end, allDay) {
			
			var dt_start = moment(start).format('YYYY-MM-DD-HH-mm');
			var dt_end = moment(end).format('YYYY-MM-DD-HH-mm');
			
			alert("dt_start="+dt_start+ " end dt _ end" + dt_end);
		},
		
		eventClick: function(event) {
			
			alert("event_id" + event.id);
			
	    },
	    
	     eventDrop: function(event) {
	    	 alert("dtd");
			
			$.ajax({
				url:'scheduleDrop',
				data:{scheduleNum:event.id, start:event.start.format('YYYY-MM-DD:HH:mm'),
					end:event.end.format('YYYY-MM-DD:HH:mm')},
				type:'POST',
                success: function(args){
					
                }
   			});
	    }, 
	    
	/*     selectHelper: true, */
	    
	 /*    droppable: true, */
/* 		
		handleWindowResize: true, */
		
/* 		eventStartEditable: true, */
		
		/* eventDurationEditable: true, */
	    
		
		/* eventResize: function(event) {
			
			$.ajax({
				url:'scheduleResize',
				data:{scheduleNum:event.id, start:event.start.format('YYYY-MM-DD:HH:mm'),
					end:event.end.format('YYYY-MM-DD:HH:mm')},
				type:'POST',
                success: function(args){
					
                }
   			});
	    } */
    })

});
</script>
<body>
<div id='calendar'></div>
</body>
</html>