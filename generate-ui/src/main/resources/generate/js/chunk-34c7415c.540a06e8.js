(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-34c7415c"],{"4f66":function(e,t,n){"use strict";n.d(t,"b",(function(){return r})),n.d(t,"a",(function(){return i}));var o=n("b775");function r(e){return Object(o["a"])({url:"/generate/tables/".concat(e),method:"get"})}function i(e){return Object(o["a"])({url:"/generate/generate",method:"post",data:e})}},"8c2a":function(e,t,n){"use strict";var o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("codemirror",e._b({attrs:{value:e.value,options:e.option},on:{"update:value":function(t){e.value=t},cursorActivity:e.onCmCursorActivity,ready:e.onCmReady,focus:e.onCmFocus,blur:e.onCmBlur,input:e.onCmInput,scroll:e.onCmScroll}},"codemirror",e.$attrs,!1))},r=[],i=n("8f94"),a=(n("f9d4"),n("7b00"),n("d5e0"),n("4ba6"),n("d69f"),n("0b6c"),n("2aed"),n("b933"),n("d72f"),n("8c33"),{name:"Codemirror",components:{codemirror:i["codemirror"]},props:{code:{type:String,default:null},option:{type:Object,default:function(){return{modes:"text/x-java",matchBrackets:!0,viewportMargin:20,connect:"align",foldGutter:!0,lineNumbers:!0}}}},data:function(){return{codemirror:null}},computed:{value:{get:function(){return this.code},set:function(e){this.$emit("update:code",e)}}},methods:{onCmCursorActivity:function(e,t,n){},onCmReady:function(e,t,n){this.codemirror=e},onCmFocus:function(e,t,n){},onCmBlur:function(e,t,n){},onCmInput:function(e){this.value=e},onCmScroll:function(){}}}),c=a,l=n("2877"),u=Object(l["a"])(c,o,r,!1,null,null,null);t["a"]=u.exports},"9a8a":function(e,t,n){"use strict";n.r(t);var o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container"},[n("el-backtop"),e.loading?n("div",[e._v("生成中...")]):n("div",[n("el-container",[n("el-aside",[n("el-button",{attrs:{icon:"el-icon-download",type:"text"},on:{click:e.downloadAll}},[e._v("下载全部")]),n("el-input",{directives:[{name:"show",rawName:"v-show",value:e.treeData.length>0,expression:"treeData.length > 0"}],staticStyle:{"margin-bottom":"10px"},attrs:{"prefix-icon":"el-icon-search",placeholder:"搜索",size:"mini",clearable:""},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),n("el-tree",{ref:"tree",attrs:{data:e.treeData,props:e.defaultProps,"filter-node-method":e.filterNode,"node-key":"id","default-expand-all":"","highlight-current":""},on:{"current-change":e.onTreeSelect}})],1),n("el-main",{directives:[{name:"show",rawName:"v-show",value:e.fileInfo.content.length>0,expression:"fileInfo.content.length > 0"}]},[n("el-button",{staticClass:"copyBtn",attrs:{type:"text",icon:"el-icon-document-copy","data-clipboard-text":e.fileInfo.content},on:{click:function(t){return e.copy(e.fileInfo.content)}}},[e._v("复制代码")]),n("el-button",{attrs:{icon:"el-icon-download",type:"text"},on:{click:function(t){return e.downloadText(e.fileInfo.fileName,e.fileInfo.content)}}},[e._v("下载当前文件")]),n("Codemirror",{attrs:{code:e.fileInfo.content},on:{"update:code":function(t){return e.$set(e.fileInfo,"content",t)}}})],1)],1)],1)],1)},r=[],i=(n("4de4"),n("d3b7"),n("159b"),n("c4e3")),a=n.n(i),c=n("21a6"),l=n("4f66"),u=n("cf45"),f=n("8c2a"),d={components:{Codemirror:f["a"]},data:function(){return{loading:!0,clientParam:{datasourceConfigId:"",tableNames:[],templateConfigIdList:[],packageName:""},treeData:[],filterText:"",defaultProps:{children:"children",label:"dirOrFileName"},content:"",fileInfo:{content:"",fileName:""},cmOptions:{value:"",mode:"text/x-java",theme:"neat",readOnly:!0}}},watch:{filterText:function(e){this.$refs.tree.filter(e)}},created:function(){var e=this,t=JSON.parse(localStorage.getItem("generateForm"));Object(l["a"])(t).then((function(t){e.loading=!1,e.treeData=t.data}))},methods:{filterNode:function(e,t){return!e||-1!==t.dirOrFileName.toLowerCase().indexOf(e.toLowerCase())},buildTreeData:function(e){for(var t=[],n={},o=0,r=e.length;o<r;o++){var i=e[o],a=i.folder,c=n[a];c||(c=[],n[a]=c),c.push(i)}for(var l in n){var u=n[l],f={fileName:l,children:this.buildChildren(u)};t.push(f)}return t},buildChildren:function(e){for(var t=[],n=0,o=e.length;n<o;n++){var r=e[n],i={fileName:r.fileName,content:r.content};t.push(i)}return t},onTreeSelect:function(e){e.children&&e.children.length>0||(console.log(e),this.fileInfo={content:e.content,fileName:e.dirOrFileName})},getSuffix:function(e){var t=e.lastIndexOf(".");return-1===t?"js":e.substring(t+1,e.length)},downloadText:function(e,t){var n=new Blob([t],{type:"text/plain;charset=utf-8"});Object(c["saveAs"])(n,e)},downloadAll:function(){var e=this.treeData,t=new a.a;this.createZip(t,e),t.generateAsync({type:"blob"}).then((function(e){Object(c["saveAs"])(e,"code-".concat((new Date).getTime(),".zip"))}))},createZip:function(e,t){var n=this;console.log(t),null!=t&&t.forEach((function(t){var o=null!=t.children&&t.children.length>0;if(o){var r=e.folder(t.dirOrFileName);n.createZip(r,t.children)}else e.file(t.dirOrFileName,t.content)}))},copy:function(e){var t=this;this.$copyText(e).then((function(e){Object(u["b"])(t,"复制成功")}))}}},s=d,m=n("2877"),p=Object(m["a"])(s,o,r,!1,null,null,null);t["default"]=p.exports},cf45:function(e,t,n){"use strict";function o(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"操作成功";e.$message({type:"success",message:t})}function r(e,t){e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(t)}n.d(t,"b",(function(){return o})),n.d(t,"a",(function(){return r}))}}]);