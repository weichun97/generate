(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-75d963ba"],{"22fe":function(e,t,a){"use strict";a.d(t,"a",(function(){return n})),a.d(t,"b",(function(){return r}));var n=[{label:"MySQL",value:1}],r=[{label:"JAVA",value:"1"}]},"5cf2":function(e){e.exports=JSON.parse('{"1":[{"expression":"自定义字段","text":"","children":[]},{"expression":"基础信息","text":"","children":[{"expression":"${base.baseDir}","text":"根目录"},{"expression":"${base.basePackageName}","text":"根包名"},{"expression":"${base.dir}","text":"目录"},{"expression":"${base.packageName}","text":"包名"},{"expression":"${base.date}","text":"日期"},{"expression":"${base.time}","text":"时间"},{"expression":"${base.datetime}","text":"日期+时间"}]},{"expression":"表信息","text":"","children":[{"expression":"${table.name}","text":"表名"},{"expression":"${table.nameLower}","text":"表名-全小写"},{"expression":"${table.nameLowerCamel}","text":"表名-小驼峰"},{"expression":"${table.nameUpperCamel}","text":"表名-大驼峰"},{"expression":"${table.nameLowerHyphen}","text":"表名-小写中划线"},{"expression":"${table.nameLowerUnderscore}","text":"表名-小写下划线"},{"expression":"${table.nameUpperUnderscore}","text":"表名-大写下划线"},{"expression":"${table.comment}","text":"表备注"}]},{"expression":"字段信息 <#list columns as column> </#list>","text":"","children":[{"expression":"${column.name}","text":"字段名"},{"expression":"${column.nameLowerCamel}","text":"字段名-小驼峰"},{"expression":"${column.nameUpperCamel}","text":"字段名-大驼峰"},{"expression":"${column.nameLowerHyphen}","text":"字段名-小写中划线"},{"expression":"${column.nameLowerUnderscore}","text":"字段名-小写下划线"},{"expression":"${column.nameUpperUnderscore}","text":"字段名-大写下划线"},{"expression":"${column.comment}","text":"备注"},{"expression":"${column.type}","text":"数据库类型"},{"expression":"${column.baseType}","text":"基础类型"},{"expression":"${column.boxType}","text":"包装类型"},{"expression":"${column.primaryFlag}","text":"是否主键"},{"expression":"${column.autoFlag}","text":"是否自增"}]}]}')},"8c2a":function(e,t,a){"use strict";var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("codemirror",e._b({attrs:{value:e.value,options:e.option},on:{"update:value":function(t){e.value=t},cursorActivity:e.onCmCursorActivity,ready:e.onCmReady,focus:e.onCmFocus,blur:e.onCmBlur,input:e.onCmInput,scroll:e.onCmScroll}},"codemirror",e.$attrs,!1))},r=[],o=a("8f94"),s=(a("f9d4"),a("7b00"),a("d5e0"),a("4ba6"),a("d69f"),a("0b6c"),a("2aed"),a("b933"),a("d72f"),a("8c33"),{name:"Codemirror",components:{codemirror:o["codemirror"]},props:{code:{type:String,default:null},option:{type:Object,default:function(){return{modes:"text/x-java",matchBrackets:!0,viewportMargin:20,connect:"align",foldGutter:!0,lineNumbers:!0}}}},data:function(){return{codemirror:null}},computed:{value:{get:function(){return this.code},set:function(e){this.$emit("update:code",e)}}},methods:{onCmCursorActivity:function(e,t,a){},onCmReady:function(e,t,a){this.codemirror=e},onCmFocus:function(e,t,a){},onCmBlur:function(e,t,a){},onCmInput:function(e){this.value=e},onCmScroll:function(){}}}),i=s,l=a("2877"),c=Object(l["a"])(i,n,r,!1,null,null,null);t["a"]=c.exports},"92a7":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container",attrs:{height:"800px"}},[a("el-form",{ref:e.saveOrUpdateFormRef,attrs:{model:e.saveOrUpdateForm,rules:e.saveOrUpdateFormRules,"label-position":"top","label-width":"80px"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:16}},[a("el-button-group",[a("el-button",{attrs:{type:"primary",loading:e.saveOrUpdateLoading},on:{click:function(t){return e.saveOrUpdate()}}},[e._v("保存")]),a("el-button",{attrs:{plain:""},on:{click:function(t){return e.$router.back()}}},[e._v("返回")])],1),a("el-form-item",{attrs:{label:"模板组",prop:"templateId"}},[a("el-select",{attrs:{size:"mini",placeholder:"模板组"},model:{value:e.saveOrUpdateForm.templateId,callback:function(t){e.$set(e.saveOrUpdateForm,"templateId",t)},expression:"saveOrUpdateForm.templateId"}},e._l(e.templates,(function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"模板名",prop:"name"}},[a("el-input",{attrs:{size:"mini"},model:{value:e.saveOrUpdateForm.name,callback:function(t){e.$set(e.saveOrUpdateForm,"name",t)},expression:"saveOrUpdateForm.name"}})],1),a("el-form-item",{attrs:{label:"目录",prop:"dir"}},[a("el-input",{attrs:{size:"mini"},model:{value:e.saveOrUpdateForm.dir,callback:function(t){e.$set(e.saveOrUpdateForm,"dir",t)},expression:"saveOrUpdateForm.dir"}})],1),a("el-form-item",{attrs:{label:"文件名",prop:"fileName"}},[a("el-input",{attrs:{size:"mini"},model:{value:e.saveOrUpdateForm.fileName,callback:function(t){e.$set(e.saveOrUpdateForm,"fileName",t)},expression:"saveOrUpdateForm.fileName"}})],1),a("el-form-item",{attrs:{label:"模板内容",prop:"content"}},[a("el-link",{attrs:{type:"primary",underline:!1,href:"http://freemarker.foofun.cn/ref_directive_if.html",target:"_blank"}},[e._v("freemark语法")]),a("Codemirror",{attrs:{code:e.saveOrUpdateForm.content},on:{"update:code":function(t){return e.$set(e.saveOrUpdateForm,"content",t)}}})],1)],1),a("el-col",{attrs:{span:8}},[a("div",{class:{hasFix:e.needFix},staticStyle:{"font-size":"14px"}},[a("h4",{staticStyle:{margin:"5px 0"}},[e._v(" 变量 "),a("span",{staticClass:"velocity-tip"},[e._v(" 点击变量复制 ")])]),a("el-tabs",{on:{"tab-click":e.onTabClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},e._l(e.langTypes,(function(e){return a("el-tab-pane",{key:e.value,attrs:{label:e.label,name:e.value,content:e.value}})})),1),a("div",{staticClass:"velocity-var"},[a("el-tree",{attrs:{data:e.treeData,props:e.defaultProps,indent:4,accordion:""},scopedSlots:e._u([{key:"default",fn:function(t){var n=t.data;return a("span",{},[n.children?a("span",[e._v(e._s(n.expression))]):a("span",[a("a",{on:{click:function(t){return e.onExpressionClick(n.expression)}}},[e._v(e._s(n.expression))]),e._v("："+e._s(n.text)+" ")])])}}])})],1)],1)])],1)],1)],1)},r=[],o=(a("b0c0"),a("d3b7"),a("159b"),a("8c2a")),s=a("5cf2"),i=a("c621"),l=a("22fe"),c=a("cf45"),u={components:{Codemirror:o["a"]},data:function(){return{templates:[],updateId:null,saveOrUpdateLoading:!1,saveOrUpdateFormRef:"saveOrUpdateFormRef",saveOrUpdateForm:{},saveOrUpdateFormRules:{templateId:[{required:!0,message:"请选择模板组",trigger:"blur"}],name:[{required:!0,message:"请输入模板名",trigger:"blur"},{min:1,max:100,message:"长度在 1 到 100 个字符",trigger:"blur"}],fileName:[{required:!0,message:"请输入文件名",trigger:"blur"},{min:1,max:100,message:"长度在 1 到 100 个字符",trigger:"blur"}],content:[{required:!0,message:"请输入模板内容",trigger:"blur"}]},activeName:"1",langTypes:l["b"],collapseActiveName:"0",treeData:[],velocityConfig:[],defaultProps:{children:"children",label:"expression"},needFix:!1,keywordHelpShow:!1}},watch:{activeName:function(e){this.load(e)},"saveOrUpdateForm.templateId":function(e){this.loadCustomFields()}},created:function(){this.saveOrUpdateForm=this.$route.params,this.updateId=this.saveOrUpdateForm.id,this.templateSelect(),this.load(this.activeName),this.loadCustomFields()},methods:{onTabClick:function(e){this.load(e.name)},onExpressionClick:function(e){var t=this;this.$copyText(e).then((function(e){Object(c["b"])(t,"复制成功")}))},load:function(e){this.treeData=s[e]},loadCustomFields:function(){var e=this;null!=this.saveOrUpdateForm.templateId?Object(i["a"])(this.saveOrUpdateForm.templateId).then((function(t){var a=[];t.data.forEach((function(e){a.push({expression:"${custom.".concat(e.key,"}"),text:e.value})})),e.treeData[0].children=a,console.log(e.treeData[0].children)})):this.treeData[0].children=[]},templateSelect:function(){var e=this;Object(i["h"])().then((function(t){e.templates=t.data}))},updateTemplateDetail:function(){var e=this;this.saveOrUpdateLoading=!0,Object(i["k"])(this.saveOrUpdateForm,this.updateId).then((function(){Object(c["b"])(e),e.saveOrUpdateLoading=!1})).catch((function(){e.saveOrUpdateLoading=!1}))},saveTemplateDetail:function(){var e=this;this.saveOrUpdateLoading=!0,Object(i["g"])(this.saveOrUpdateForm).then((function(){Object(c["b"])(e),e.saveOrUpdateLoading=!1})).catch((function(){e.saveOrUpdateLoading=!1}))},saveOrUpdate:function(){var e=this;this.$refs[this.saveOrUpdateFormRef].validate((function(t){t&&(null==e.updateId?e.saveTemplateDetail():e.updateTemplateDetail())}))}}},p=u,m=(a("eb79"),a("2877")),d=Object(m["a"])(p,n,r,!1,null,"64f1a8cf",null);t["default"]=d.exports},b6b1:function(e,t,a){},c621:function(e,t,a){"use strict";a.d(t,"c",(function(){return r})),a.d(t,"f",(function(){return o})),a.d(t,"i",(function(){return s})),a.d(t,"d",(function(){return i})),a.d(t,"a",(function(){return l})),a.d(t,"j",(function(){return c})),a.d(t,"h",(function(){return u})),a.d(t,"b",(function(){return p})),a.d(t,"g",(function(){return m})),a.d(t,"k",(function(){return d})),a.d(t,"e",(function(){return f}));var n=a("b775");function r(e){return Object(n["a"])({url:"/template/query",method:"get",params:e})}function o(e){return Object(n["a"])({url:"/template/save",method:"post",data:e})}function s(e,t){return Object(n["a"])({url:"/template/update/".concat(t),method:"put",data:e})}function i(e){return Object(n["a"])({url:"/template/remove/".concat(e),method:"delete"})}function l(e){return Object(n["a"])({url:"/template/customFields/".concat(e),method:"get"})}function c(e,t){return Object(n["a"])({url:"/template/updateCustomFields/".concat(t),method:"put",data:e})}function u(){return Object(n["a"])({url:"/template/select",method:"get"})}function p(e){return Object(n["a"])({url:"/template/listDetail",method:"get",params:e})}function m(e){return Object(n["a"])({url:"/template/saveDetail",method:"post",data:e})}function d(e,t){return Object(n["a"])({url:"/template/updateDetail/".concat(t),method:"put",data:e})}function f(e){return Object(n["a"])({url:"/template/removeDetail/".concat(e),method:"delete"})}},cf45:function(e,t,a){"use strict";function n(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"操作成功";e.$message({type:"success",message:t})}function r(e,t){e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(t)}a.d(t,"b",(function(){return n})),a.d(t,"a",(function(){return r}))},eb79:function(e,t,a){"use strict";a("b6b1")}}]);