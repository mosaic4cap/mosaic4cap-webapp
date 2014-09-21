/**
 * Created by svenklemmer on 18.09.14.
 */
$(document).ready(function () {
    //function to send adress id to modal and work with it with angular js
    $('#adressModal').on('shown.bs.modal', function (event) {
        $("#adressId").val($(event.relatedTarget).data('adress-id'));
    });

    //function to send adress id to modal and work with it with angular js
    $('#bankDataModal').on('shown.bs.modal', function (event) {
        $("#bankDataId").val($(event.relatedTarget).data('bankdata-id'));
    });
});
