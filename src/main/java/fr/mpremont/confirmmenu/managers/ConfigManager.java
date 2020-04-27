package fr.mpremont.confirmmenu.managers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.confirmmenu.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		String confv = MainClass.getInstance().getConfig().getString("ConfigVersion");
		if(confv == null || confv == "" || (!confv.contains("#"))) {
			
			Bukkit.getConsoleSender().sendMessage("§b[§eConfirmMenu§b] §cInvalid configuration file !");
			result = false;
			
		}else {
			
			Configuration c = MainClass.getInstance().getConfig();
			String version = c.getString("ConfigVersion").split("#")[0];
			
			if(!version.equalsIgnoreCase("1.1.5")) {
				
				setBasic(c);
				MainClass.getInstance().reloadConfig();
				c = MainClass.getInstance().getConfig();
				
			}
			
			String lang = c.getString("ConfigVersion").split("#")[1];
			String current = c.getString("Language");
			
			if(!lang.equalsIgnoreCase(current)) {
				
				if(current.equalsIgnoreCase("FR")) {
					setFR(c);
				}else if(current.equalsIgnoreCase("ES")) {
					setES(c);
				}else if(current.equalsIgnoreCase("DE")) {
					setDE(c);;
				}else if(current.equalsIgnoreCase("TK")) {
					setTK(c);;
				}else if(current.equalsIgnoreCase("ZH")) {
					setZH(c);;
				}else if(current.equalsIgnoreCase("RU")) {
					setRU(c);;
				}else if(current.equalsIgnoreCase("PL")) {
					setPL(c);;
				}else if(current.equalsIgnoreCase("CZ")) {
					setCZ(c);;
				}else if(current.equalsIgnoreCase("OTHER")) {
					setOTHER(c);
				}else {
					setEN(c);
				}
				
				MainClass.getInstance().reloadConfig();
				
			}
			
		}
		
		return result;
		
	}
	
	private static void setCZ(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eJsi si jistej ?";
		String WriteConfirmMessage = "&ePotvrďte stisknutím tlačítka POTVRDIT, nebo klikněte na něco jiného pro zrušení.";
		String cancelMessage = "&cZrušeno !";
		String menuTitle = "&8&lPotvrdit";
		String menuConfirm = "&a&lPotvrdit";
		String menuCancel = "&c&lZrušit";
		String newVersion = "&eNová verze je dostupna !";
		String updateFail = "&cNelze zkontrolovat aktualizace !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List příkazu u kterých ze zobrzí menu\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Seznam příkazů, které vyžadují potvrzení napsáním „confirm“\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Povolit zvuky\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP hráči mají povolení přeskočit potvrzení ve výchozím nastavení ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Zprávy (Bravy jsou povolené)\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Změna jazyka automaticky změní konfiguraci při příštím restartu\n"
					+ "# Dostupné jazyky : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"CZ\"\n"
					+ "# Kontrola aktualizací\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Nedotýkejte se] Konfigurační verze\n"
					+ "ConfigVersion: 1.1.5#cz");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setPL(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eJesteś pewien?";
		String WriteConfirmMessage = "&eNapisz CONFIRM aby potwierdzić, lub wpisz cokolwiek, aby anulować.";
		String cancelMessage = "&cAnuluj!";
		String menuTitle = "&8&lPOTWIERDŹ";
		String menuConfirm = "&a&lPOTWIERDŹ";
		String menuCancel = "&c&lANULUJ";
		String newVersion = "&eNowa wersja pluginu jest już dostępna !";
		String updateFail = "&cNie można sprawdzić dostępności aktualizacji !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# Lista komend wymagających potwierdzenia\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Lista komend wymagających potwierdzenia poprzez wpisanie \"confirm\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Włącz dźwięk menu\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Czy OP domyślnie posiada uprawnienia do pomijania potwierdzeń ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Treść ( Kody kolorów są ważne )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Zmiana języka nastąpi po restarcie serwera\n"
					+ "# Dostępne języki : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"PL\"\n"
					+ "# Sprawdzaj dostępność aktualizacji i wyślij wiadomość do konsoli\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Nie zmieniaj!] Wersja konfiguracji\n"
					+ "ConfigVersion: 1.1.5#pl");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setRU(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eВы уверены?";
		String WriteConfirmMessage = "&eНапишите CONFIRM для подтверждения или любой другой текст для отмены.";
		String cancelMessage = "&cОтменено !";
		String menuTitle = "&8&lПОДТВЕРЖДЕНИЕ";
		String menuConfirm = "&a&lПОДТВЕРДИТЬ";
		String menuCancel = "&c&lОТМЕНИТЬ";
		String newVersion = "&eДоступна новая версия плагина, необходимо обновиться !";
		String updateFail = "&cНевозможно найти обновления !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# Список команд, которые нуждаются в подтверждении\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Список команд, которые нуждаются в подтверждении, через написание \"confirm\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Звук при открытии меню подтверждения\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Операторы сервера могут пропустить подтверждение (confirmmenu.skip)\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Локализация (с поддержкой цветовых кодов)\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Смена языка приведёт к автоматической смене конфигурации при рестарте сервера\n"
					+ "# Доступные языки : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"RU\"\n"
					+ "# Проверять ли обновления и оповещать о новых версиях в консоль\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Не трогать!] Версия конфигурации\n"
					+ "ConfigVersion: 1.1.5#ru");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setZH(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&e你确定吗 ?";
		String WriteConfirmMessage = "&e输入CONFIRM以确认, 输入其他字符以取消.";
		String cancelMessage = "&c你取消了这次操作 !";
		String menuTitle = "&8&l确认界面";
		String menuConfirm = "&a&l确认";
		String menuCancel = "&c&l取消";
		String newVersion = "&e插件有新版本更新 !";
		String updateFail = "&c无法检测更新 !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont 汉化by Like_Wind ==========\n"
					+ "\n"
					+ "# 需要点击确认才能继续执行的命令\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# 需要输入“确认”才能继续执行的命令\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# 界面有无声音\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# 默认情况下op是否有权限跳过确认 ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# 聊天信息 ( 可以使用颜色代码 )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# 更改语言，将在重新载入插件时更新\n"
					+ "# 可用语言 : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"ZH\"\n"
					+ "# 是否检测更新\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [不要更改！] 插件版本\n"
					+ "ConfigVersion: 1.1.5#zh");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setTK(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eEmin misin ?";
		String WriteConfirmMessage = "&eCONFIRM yazarak onayla, yoksa kısa sürede iptal olacak.";
		String cancelMessage = "&cIptal edildi !";
		String menuTitle = "&8&lONAYLA";
		String menuConfirm = "&a&lONAYLA";
		String menuCancel = "&c&lIPTAL ET";
		String newVersion = "&eEklentinin yeni bir versiyonu mevcut. Lütfen eklentiyi güncelleyin.";
		String updateFail = "&cGüncellemeler kontrol edilemedi !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# Onaylama gerektiren komutlar\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# \"confirm\" yazılarak onaylanacak komutlar\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Menü açma sesini etkinleştir\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP olanların Onaylama menüsünü yetki ile atlaması (confirmmenu.skip)\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Mesajlar (Renk kodları kullanılabilir)\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Dil'in değiştirilmesi yeniden başlatmadan sonra aktif olacaktır.\n"
					+ "# Mevcut diller : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"TK\"\n"
					+ "# Güncellemeleri kontrol et ve konsol'a mesaj gönder\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [DOKUNMA] Ayarlar dosyası versiyonu\n"
					+ "ConfigVersion: 1.1.5#tk");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setDE(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eBist du sicher ?";
		String WriteConfirmMessage = "&eSchreibe CONFIRM, um zu bestätigen, oder etwas anderes um abzubrechen.";
		String cancelMessage = "&cAbgrebrochen!";
		String menuTitle = "&8&lBESTÄTIGE";
		String menuConfirm = "&a&lBESTÄTIGE";
		String menuCancel = "&c&lABBRECHEN";
		String newVersion = "&eEine neue Version des Plugins ist verfügbar !";
		String updateFail = "cKonnte nicht nach Updates suchen !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# Liste der Befehle, die eine Bestätigung brauchen durch ein Inventar (GUI)\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Liste der Befehle, die eine Bestätigung durch das Schreiben von \"confirm\" brauchen\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Aktiviere Inventar Öffnen Sound?\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP-Spieler haben standardmäßig die Erlaubnis, die Bestätigung zu überspringen ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Nachrichten ( Farb-Codes können verwendet werden )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Durch das Ändern der Sprache wird die Konfiguration beim nächsten Neustart automatisch geändert und angewendet.\n"
					+ "# Verfügbare Sprachen : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"DE\"\n"
					+ "# Suche nach updates und schreibe dies in die Konsole?\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [NICHT VERÄNDERN!] Konfigurations-Version\n"
					+ "ConfigVersion: 1.1.5#de");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setOTHER(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String WriteConfirmMessage = c.getString("Text.WriteConfirmMessage");
		if(WriteConfirmMessage == null || WriteConfirmMessage == "") {
			confirmMessage = "&eWrite CONFIRM to confirm, or something else to cancel.";
		}
		String cancelMessage = c.getString("CancelMessage");
		if(cancelMessage == null || cancelMessage == "") {
			cancelMessage = "&cCanceled !";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# List of commands that require a confirmation by writing \"confirm\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"OTHER\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.1.5#other");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setES(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commandsWrite = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eEstas seguro ?";
		String WriteConfirmMessage = "&eEscriba CONFIRM para confirmar, o algo más para cancelar.";
		String cancelMessage = "&c¡Cancelado!";
		String menuTitle = "&8&lCONFIRMAR";
		String menuConfirm = "&a&lCONFIRMAR";
		String menuCancel = "&c&lCANCELAR";
		String newVersion = "&e¡Una nueva versión del plugin está disponible!";
		String updateFail = "&c¡No se pueden buscar actualizaciones!";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu de MaximePremont ==========\n"
					+ "\n"
					+ "# Lista de comandos que necesitan confirmación\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Lista de comandos que pueden confirmarse escribiendo \"CONFIRM\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Activa el sonido de apertura del menú\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Los jugadores OP tienen permiso para pasar la confirmación ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Mensajes ( los códigos de colores funcionan )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Cambiar el idioma cambiará automáticamente la configuración en el próximo reinicio\n"
					+ "# Idiomas disponibles : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"ES\"\n"
					+ "# Comprube si hay un actualización e indíquela en la consola\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [No modificar] Versión de configuración\n"
					+ "ConfigVersion: 1.1.5#es");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setFR(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commandsWrite = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eÊtes-vous sûr ?";
		String WriteConfirmMessage = "&eEcris CONFIRM pour confirmer, écris autre chose pour annuler.";
		String cancelMessage = "&cAnnulé !";
		String menuTitle = "&8&lCONFIRMATION";
		String menuConfirm = "&a&lCONFIRMER";
		String menuCancel = "&c&lANNULER";
		String newVersion = "&eUne nouvelle version du plugin est disponible !";
		String updateFail = "&cImpossible de vérifier les mises à jour !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu par MaximePremont ==========\n"
					+ "\n"
					+ "# Liste des commandes qui ont besoins d'une confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# Liste des commandes qui peuvent êtres confirmées en écrivant \"CONFIRM\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Activer le son d'ouverture du menu\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Les joueurs OP ont la permission de passer la confirmation ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( les codes couleurs fonctionnent )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changer la langue modifiera automatiquement la configuration au prochain redémarrage\n"
					+ "# Langages disponibles : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"FR\"\n"
					+ "# Vérifier si il y à une mise à jour et l'indiquer dans la console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Ne pas modifier] Version de la configuration\n"
					+ "ConfigVersion: 1.1.5#fr");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setEN(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eAre you sure ?";
		String WriteConfirmMessage = "&eWrite CONFIRM to confirm, or something else to cancel.";
		String cancelMessage = "&cCanceled !";
		String menuTitle = "&8&lCONFIRM";
		String menuConfirm = "&a&lCONFIRM";
		String menuCancel = "&c&lCANCEL";
		String newVersion = "&eA new version of the plugin is available !";
		String updateFail = "&cCould not check for updates !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# List of commands that require a confirmation by writing \"confirm\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \"EN\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.1.5#en");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setBasic(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String commandsWrite = c.getString("CommandsWrite");
		if(commandsWrite == null || commandsWrite == "") {
			commands = "kick, ban";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String WriteConfirmMessage = c.getString("Text.WriteConfirmMessage");
		if(WriteConfirmMessage == null || WriteConfirmMessage == "") {
			confirmMessage = "&eWrite CONFIRM to confirm, or something else to cancel.";
		}
		String cancelMessage = c.getString("CancelMessage");
		if(cancelMessage == null || cancelMessage == "") {
			cancelMessage = "&cCanceled !";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String language = c.getString("Language");
		if(language == null || language == "") {
			language = "EN";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/ConfirmMenu/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require a confirmation with menu\n"
					+ "Commands: \""+commands+"\"\n"
					+ "# List of commands that require a confirmation by writing \"confirm\"\n"
					+ "CommandsWrite: \""+commandsWrite+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    WriteConfirmMessage: \""+WriteConfirmMessage+"\"\n"
					+ "    CancelMessage: \""+cancelMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | DE | TK | ZH | RU | PL | CZ | OTHER\n"
					+ "Language : \""+language+"\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.1.5#CREATION");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
