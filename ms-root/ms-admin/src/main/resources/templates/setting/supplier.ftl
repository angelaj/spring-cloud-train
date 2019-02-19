<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>供应商管理</title>
		<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
		<meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
		<link rel="shortcut icon" href="${ctx!}/assets/favicon.ico">
		<link href="${ctx!}/assets/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="${ctx!}/assets/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link href="${ctx!}/assets/css/animate.min.css" rel="stylesheet">
		<link href="${ctx!}/assets/css/style.min862f.css?v=4.1.0" rel="stylesheet">
		<link href="${ctx!}/assets/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
		<link href="${ctx!}/assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet">

		<script type="text/javascript" src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
		<script type="text/javascript" src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>
		<script type="text/javascript" src="${ctx!}/assets/js/content.min.js?v=1.0.0"></script>
		<script type="text/javascript" src="${ctx!}/assets/plugins/bootstrap-table/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="${ctx!}/assets/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="${ctx!}/assets/plugins/underscore/js/underscore-min.js"></script>
		<script type="text/javascript" src="${ctx!}/assets/plugins/gritter/js/jquery.gritter.min.js"></script>

		<script type="text/javascript" src="${ctx!}/app/js/common/date.js"></script>
		<script type="text/javascript" src="${ctx!}/app/js/setting/supplier.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				// 设置underscore的template，将模板匹配字符改为{{}}
				_.templateSettings = {
					evaluate: /\{\{([\s\S]+?)\}\}/g,
					interpolate: /\{\{=([\s\S]+?)\}\}/g,
					escape: /\{\{-([\s\S]+?)\}\}/g
				};

				var supplierList = new Web_SupplierList({

				});
			});
		</script>
		<script id="temp_supplier_action" type="text/template">
			<span data-sign="action_supplier" data-id="{{=id}}" data-suppliername="{{=supplierName}}">
	            {{ _.each(actions, function(action){ }}
	            	<a class="btn btn-sm {{=action.color}} {{=action.dis}}" title="{{=action.name}}" data-action="{{=action.value}}">
	            		<i class="fa {{=action.iconstyle}}"></i>
	            	</a>
	            {{ }); }}
	        </span>
		</script>
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row-fluid">
				<h3 class="page-title">
                	供应商管理页面<small>主要新建、修改供应商信息</small>
            	</h3>
			</div>

			<div id="div_supplier_list" class="row-fluid">
				<div class="col-sm-12">
					<div class="panel-body">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">查询条件</h3>
							</div>
							<div class="panel-body">
								<form id="form_search_supplier" class="form-horizontal">
									<div class="form-group" style="margin-top:15px">
										<label class="control-label col-sm-2" for="se_supplierids">供应商ID</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="se_supplierids" placeholder="输入供应商ID，多个之间用,分隔" />
										</div>
										<label class="control-label col-sm-2" for="se_suppliername">供应商名称</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" id="se_suppliername" placeholder="输入供应商名称，进行模糊查询" />
										</div>
										<div class="col-sm-2">
											<button type="button" id="btn_search_supplier" class="btn btn-primary">查询</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div id="toolbar_supplierlist">
							<div class="btn-group btn-group-sm">
								<button id="btn_add_supplier" type="button" class="btn btn-primary">
                            		<span class="glyphicon">添加</span>
                        		</button>
							</div>
						</div>
						<table id="table_supplierlist"></table>
					</div>
				</div>
			</div>

			<div id="div_supplier_detail" class="row-fluid hide">
				<h3 class="form-section">
                <button id="action_supplier_back" class="btn btn-success" data-toggle="modal" data-target="#supplierSaveBackModal">返回列表</button>
            </h3>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">供应商设置</h3>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->
						<form id="form_supplier" class="form-horizontal" role="form">
							<input type="hidden" name="id" value="" />
							<div class="form-group">
								<label class="col-sm-2 control-label"></label>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="required">*</span>供应商名称：</label>
								<div class="col-sm-10">
									<input type="text" id="supplierName" name="supplierName" placeholder="请输入供应商名称" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">联系人：</label>
								<div class="col-sm-10">
									<input type="text" id="contact" name="contact" placeholder="请输入联系人" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">手机号码：</label>
								<div class="col-sm-10">
									<input type="text" id="phone" name="phone" placeholder="请输入手机号码" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">邮箱：</label>
								<div class="col-sm-10">
									<input type="email" id="email" name="email" placeholder="请输入邮箱" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">电话号码：</label>
								<div class="col-sm-10">
									<input type="text" id="telephone" name="telephone" placeholder="请输入电话号码" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">地址：</label>
								<div class="col-sm-10">
									<input type="text" id="address" name="address" placeholder="请输入地址" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注：</label>
								<div class="col-sm-10">
									<textarea id="remark" name="remark" class="form-control" required="" aria-required="true" placeholder="请输入备注"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<button id="btn_supplier_save" class="btn btn-primary" type="button">保存</button>
									<button id="btn_supplier_cancle" class="btn btn-default" type="button" data-toggle="modal" data-target="#supplierSaveBackModal">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- 模态框（返回） -->
		<div class="modal fade" id="supplierSaveBackModal" tabindex="-1" role="dialog" aria-labelledby="supplierSaveBackModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="supplierSaveBackModalLabel">提示</h4>
					</div>
					<div class="modal-body">确定放弃保存吗？</div>
					<div class="modal-footer">
						<button id="supplierSaveCancle" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="supplierSaveBack" type="button" class="btn btn-primary">确认</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 模态框（删除） -->
		<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="delModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
		                    </button>
						<h4 class="modal-title" id="dleModalLabel">
		                        提示
		                    </h4>
					</div>
					<div class="modal-body">
						确定要删除吗？
					</div>
					<div class="modal-footer">
						<button id="delCancle" type="button" class="btn btn-default" data-dismiss="modal">
		                        取消
		                    </button>
						<button id="delBack" type="button" class="btn btn-primary">
		                        确认
		                    </button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		<div id="modal_confirm" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modal_confirm_header" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
		                    </button>
						<h3 id="modal_confirm_header">确认信息</h3>
					</div>
					<div class="modal-body">
						<p id="modal_confirm_info"></p>
					</div>
					<div class="modal-footer">
						<button id="btn_modal_confirm_ok" class="btn btn-danger" data-dismiss="modal">确定</button>
						<button class="btn btn-success" data-dismiss="modal" aria-hidden="true">取消</button>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>