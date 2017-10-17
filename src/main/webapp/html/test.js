// 指定待显示的模型或图纸（viewToken从服务端获取）
	var viewToken = '33d5ac1dc6e640eba3c21adf95b01a00';
	var viewer3D ;
	// 初始化显示组件
	var options = new BimfaceSDKLoaderConfig();
	options.viewToken = viewToken;
	BimfaceSDKLoader.load(options, successCallback, failureCallback);
	
	function successCallback(viewMetaData) {		
		
		// 判断是否为3D模型
		if (viewMetaData.viewType != "3DView") {
			return;
		}

		// 获取DOM元素
		var dom4Show = document.getElementById('domId');
		
		// 配置参数
		var config = new Glodon.Bimface.Viewer.Viewer3DConfig();
		config.domElement = dom4Show;

		// 创建viewer3D对象
		viewer3D = new Glodon.Bimface.Viewer.Viewer3D(config);

		// 添加模型
		viewer3D.addView(viewToken);
		
		// 监听添加view完成的事件
		viewer3D.addEventListener(Glodon.Bimface.Viewer.Viewer3DEvent.ViewAdded, function(selectionData) {

			// 渲染3D模型
			viewer3D.render();
			alert(selectionData);

			// eg.
			// 隐藏ViewHouse
			// viewer3D.hideViewHouse();		
		});
		viewer3D.addEventListener(Glodon.Bimface.Application.WebApplication3DEvent.ComponentsSelectionChanged,function (selectionData) {
			console.log(selectionData);
			// 改变构件的颜色
			var redColor = new Glodon.Web.Graphics.Color(0, 255, 255, 1);
			viewer3D.overrideComponentsColorById(selectionData.elementId, redColor);
		});

	}
	
	function failureCallback(error) {
		console.log(error);
	};
	var camera;
	function addviewpoint()
	{
		var ul=document.getElementById("viewpoint");
		var obj=document.createElement("li");
		
		//获取当前视点
		camera=viewer3D.getCameraStatus();
		
		//保存当前视点
		var text = window.prompt("请输入视点的名称","视点A");
		obj.innerHTML="<a href='javascript:void(0);' onclick='setcamera()'>"+text+"</a>";
		ul.appendChild(obj);
	}
	//恢复视点
	function setcamera()
	{
	  viewer3D.setCameraStatus(camera);
	}