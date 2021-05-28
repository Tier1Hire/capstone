// "use strict";


// document.addEventListener('DOMContentLoaded', function() {
//     var calendarEl = document.getElementById('calendar');
//     var calendar = new FullCalendar.Calendar(calendarEl, {
//         initialView: 'dayGridMonth',
//         initialDate: '2021-05-07',
//         headerToolbar: {
//             left: 'prev,next today',
//             center: 'title',
//             right: 'dayGridMonth,timeGridWeek,timeGridDay'
//         },
//     });
//     calendar.render();
//     calendar.setOption('contentHeight', 650);
// });

// let initialize_calendar;
// initialize_calendar = function () {
//     $('.calendar').each(function () {
//         let calendar = $(this);
//         calendar.fullCalendar({
//             header: {
//                 left: 'prev,next today',
//                 center: 'title',
//                 right: 'month,agendaWeek,agendaDay'
//             },
//             selectable: true,
//             selectHelper: true,
//             editable: true,
//             eventLimit: true,
//
//             select: function (start, end) {
//                 $.getScript('/events/new', function () { // add js to same static or elsewhere?
//                     $('#event_date_range').val(moment(start).format() + ' - ' + moment(end).format());
//                     $('.start_hidden').val(moment(start).format());
//                     $('.end_hidden').val(moment(end).format());
//                 });
//                 calendar.fullCalendar('unselect');
//             }
//         });
//     })
// };
// $(document).on(load, initialize_calendar);

$(document).ready(function() {

    $('#calendar').fullCalendar({
        defaultDate: '2014-11-01',
        editable: true,
        eventLimit: true, // allow "more" link when too many events
        events: [
            {
                title: 'All Day Event',
                start: '2014-11-01'
            },
            {
                title: 'Long Event',
                start: '2014-11-07',
                end: '2014-11-10'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2014-11-09T16:00:00'
            },
            {
                id: 999,
                title: 'Repeating Event',
                start: '2014-11-16T16:00:00'
            },
            {
                title: 'Conference',
                start: '2014-11-11',
                end: '2014-11-13'
            },
            {
                title: 'Meeting',
                start: '2014-11-12T10:30:00',
                end: '2014-11-12T12:30:00'
            },
            {
                title: 'Lunch',
                start: '2014-11-12T12:00:00'
            },
            {
                title: 'Meeting',
                start: '2014-11-12T14:30:00'
            },
            {
                title: 'Happy Hour',
                start: '2014-11-12T17:30:00'
            },
            {
                title: 'Dinner',
                start: '2014-11-12T20:00:00'
            },
            {
                title: 'Birthday Party',
                start: '2014-11-13T07:00:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2014-11-28'
            }
        ]
    });

});