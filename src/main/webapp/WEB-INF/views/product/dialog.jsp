<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 7/4/2021
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Trigger the modal with a button
data-toggle="modal" data-target="#myModal" cái này dúng để show modal
-->

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send to friend</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="emailFrom" >From Email</label>
                    <input id="emailFrom" type="text"  class="form-control">
                </div>
                <div class="form-group">
                    <label for="emailTo" >To Email</label>
                    <input id="emailTo" type="text"  class="form-control">
                </div>
                <div class="form-group">
                    <label for="comment" >Comments</label>
                    <textarea id="comment" class="form-control" rows="3"></textarea>
                </div>
                <input type="hidden" id="id">
            </div>
            <div class="modal-footer">
                <button  class="btn btn-default btn-send" >Send</button>
                <button  class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
