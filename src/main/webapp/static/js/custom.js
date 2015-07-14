$(document).ready(function() {
	// === 所有input:submit的控件点击后,将其设置为disabled不可用,页面弹出遮罩层===//
	$("button[type=submit]").on('click', function(){
		var $this = $(this);
		$this.closest("form").valid() && $this.addClass("disabled").closest("body").modalmanager('loading');
	});

	$("a.loading").on('click', function(){
	   $("body").modalmanager('loading');
	});
	
	$('.tip').tooltip();	
	$('.tip-left').tooltip({ placement: 'left' });	
	$('.tip-right').tooltip({ placement: 'right' });	
	$('.tip-top').tooltip({ placement: 'top' });	
	$('.tip-bottom').tooltip({ placement: 'bottom' });	
	
	$('.datepicker').datepicker();
	
    $("#uploadImage").click(function(){
    	$("#file").click();
    });
});	

function checkFloat(id) {
	var reg = /^[1-9]{1}\d*(\.\d{1,2})?$/;
	if (!reg.test($("#"+id).val())) {
		showError(id, "");
	} else {
		displayError(id);
	}
}

function showError(id, tip) {
	var defaultTip = "请输入正确格式的值";
	if (tip=="") {
		tip = defaultTip; 
	}
	if ($("#"+id).next().html()==undefined) {
		$("#"+id).after("<span class=\"text-danger\" for=\""+id+"\">"+tip+"</span>");
	} else {
		$("#"+id).next().css("display","inline").html(tip);
	}
	$("#"+id).val("");
	$("#"+id).parent().parent().addClass("has-error");
}

function displayError(id) {
	if ($("#"+id).next().html()!=undefined) {
		$("#"+id).next().css("display","none");
		$("#"+id).parent().parent().removeClass("has-error");
	}
}

function ajaxUpload(fileid, imgid, fieldid, context, defaultImage) {
   	$("#"+imgid).replaceWith("<img id=\""+imgid+"\" style=\"width:49px; height:49px;\" src=\""+context+"/static/images/ajaxloading.gif\">");
    $.ajaxFileUpload({
        url: context+'/upload',
        type: 'post',
        secureuri: false,
        fileElementId: fileid,
        dataType: 'json',
        success: function(data){
            if (data.result=="success") {
           		$("#"+imgid).replaceWith("<img src=\""+context+"/static/images/ok.png\">");
           		$("#"+fieldid).val(data.filePath);
            } else {
            	alert(data.msg);
            }
        },
        error: function(data){
            alert("上传文件失败，请重新上传！");
       		$("#"+imgid).attr("src","\""+context+"/static/images/"+defaultImage+"\">");
        }
    });	
}    