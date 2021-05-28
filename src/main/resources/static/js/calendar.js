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

let initialize_calendar;
initialize_calendar = function () {
    $('.calendar').each(function () {
        let calendar = $(this);
        calendar.fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            editable: true,
            eventLimit: true,

            select: function (start, end) {
                $.getScript('/events/new', function () {
                    $('#event_date_range').val(moment(start).format() + ' - ' + moment(end).format());
                    $('.start_hidden').val(moment(start).format());
                    $('.end_hidden').val(moment(end).format());
                });
                calendar.fullCalendar('unselect');
            }
        });
    })
};
$(document).on(load, initialize_calendar);