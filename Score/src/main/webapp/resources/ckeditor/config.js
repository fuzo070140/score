/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html
	config.language = 'ko'; // 언어는 한글
	config.enterMode = '1' ,// 엔터모드는 <br/>
	config.toolbarCanCollapse = true; // 에디터 메뉴 축소/확대 가능 버튼 보이기
	
	config.resize_dir = 'both'  //  사이즈 둘 다 조정
	config.resize_minWidth = 200;
	//config.resize_maxWidth = 400;
	config.resize_minHeight = 200;
	config.resize_maxHeight = 600;
/*	// 업로드 설정
	config.filebrowserUploadUrl      = '/upld/uploadFile.do?type=Files',
	config.filebrowserImageUploadUrl = '/upld/uploadFile.do?type=Images',
	config.filebrowserWindowWidth = '640',
	config.filebrowserWindowHeight= '480'*/
	// 메뉴 버튼
	//https://blog.naver.com/PostView.nhn?blogId=jskimmail&logNo=221600848149&categoryNo=26&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=search
	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];
	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
};
CKEDITOR.on('dialogDefinition', function( ev ){
	var dialog = ev.data.definition.dialog;
	var dialogName = ev.data.name;
    var dialogDefinition = ev.data.definition;
  
    switch (dialogName) {
        case 'image': // 이미지 속성창이 보일때 안보이게 하기 위해서 .
        	
            //dialogDefinition.removeContents('info');
            dialogDefinition.removeContents('Link');
            dialogDefinition.removeContents('advanced');
            
            dialog.on('show', function (obj) {
        		this.selectPage('Upload'); //업로드텝으로 시작
            });
            break;
    }
});