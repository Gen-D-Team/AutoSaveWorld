move:
	@mvn package -f "e:\Java\AutoSaveWorld\pom.xml"
	@del E:\server\plugins\autosaveworld-0.1.jar
	@move "E:\Java\AutoSaveWorld\target\autosaveworld-0.1.jar" "E:\server\plugins"
	
run:
	@cls
	@cd E:\server && start start.bat
