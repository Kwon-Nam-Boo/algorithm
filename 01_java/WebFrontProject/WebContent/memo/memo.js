// 메모 추가 버튼 클릭시 화면에 메모를 보여주기: createBtn
// 문서가 로딩 된 다음  create 실행하게
$(function(){
	$("#createBtn").click(function(){
		new Memo().create();
	});
});

function Memo(){
	this.$note =null;
}
// create()
Memo.prototype.create = function(){
	console.log("create");
	
	var $note =  $(
		`<div class="memo-note" >
				<!-- bar  -->
				<div class ="memo-bar">
					<span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
				</div>
				<!-- content -->
				<div class="memo-edit">
					<textarea class ="memo-edit-area"></textarea>
				</div>
			</div>`
	);
	$note.appendTo($(".memo-area"));
	
	this.$note = $note;
	this.drag();
};
// drag()
Memo.prototype.drag = function(){
	this.$note.draggable();
};
// display()
Memo.prototype.display = function(){};
// fix()
Memo.prototype.fix = function(){};
// del()
Memo.prototype.del = function(){};