package dev.kaan.game.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {
	public static BufferedImage startbutton,startClicked,exitbutton,exitClicked,rulesbutton,rulesClicked,crossedSwords,title,background,gameBackground,player1turn,player2turn,player3turn,rules,endBack,player1W,player2W,player3W;
	public static ArrayList<BufferedImage> RedRegions=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> BlueRegions=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> YellowRegions=new ArrayList<BufferedImage>();
	
	public static ArrayList<BufferedImage> startButtons=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> ruleButtons=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> exitButtons=new ArrayList<BufferedImage>();
	
	public static ArrayList<BufferedImage> player1=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> player2=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> player3=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> startgame=new ArrayList<BufferedImage>();
	
	public static ArrayList<BufferedImage> chooseAtt=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> chooseDef=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> attackButtons=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> rollAtt=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> rollDef=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> backButton=new ArrayList<BufferedImage>();

	public static ArrayList<BufferedImage> returnmenu=new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> exit=new ArrayList<BufferedImage>();
	
	public static void init() {
		redSheets();
		DarkRedSheets();
		blueSheets();
		darkBlueSheets();
		Yellowsheets();
		DarkYellowsheets();
		gameButtons();
		background=ImageLoader.loadImage("/textures/background.png");
		gameBackground=ImageLoader.loadImage("/textures/gameScenebackground.png");
		rules=ImageLoader.loadImage("/textures/rules.png");
		endBack=ImageLoader.loadImage("/textures/endBack.png");
		
	}
	
	public static void gameButtons() {
		SpriteSheet buttonSheet=new SpriteSheet(ImageLoader.loadImage("/textures/gamescenestaff.png"));
		
		chooseAtt.add(buttonSheet.crop(23, 23, 205, 139));
		chooseAtt.add(buttonSheet.crop(242, 27, 205, 139));
		
		chooseDef.add(buttonSheet.crop(24, 178, 205, 139));
		chooseDef.add(buttonSheet.crop(245, 180, 205, 139));
		
		attackButtons.add(buttonSheet.crop(491, 173, 109, 118));
		attackButtons.add(buttonSheet.crop(632, 175, 109, 118));
		
		rollAtt.add(buttonSheet.crop(623, 505, 121, 50));
		rollAtt.add(buttonSheet.crop(762, 503, 121, 50));
		
		rollDef.add(buttonSheet.crop(652, 369, 51, 106));
		rollDef.add(buttonSheet.crop(749, 368, 51, 106));

		player1turn=buttonSheet.crop(48, 368, 254, 122);
		player2turn=buttonSheet.crop(343, 366, 258, 122);
		player3turn=buttonSheet.crop(40, 513, 262, 122);
		
		SpriteSheet bSheet=new SpriteSheet(ImageLoader.loadImage("/textures/endgamestatesheet.png"));
		
		returnmenu.add(bSheet.crop(18, 391, 473, 77));
		returnmenu.add(bSheet.crop(13, 601, 473, 77));
		
		exit.add(bSheet.crop(45, 502, 139, 77));
		exit.add(bSheet.crop(226, 500, 139, 77));
		
		player1W=bSheet.crop(21, 140, 338, 110);
		player2W=bSheet.crop(17, 264, 338, 110);
		player3W=bSheet.crop(13, 11, 338, 110);
	}
	public static void menuSheets() {
		SpriteSheet menuSheet=new SpriteSheet(ImageLoader.loadImage("/textures/menuSpritesheet.png"));
		
		startbutton=menuSheet.crop(8, 8, 275, 110);
		startButtons.add(startbutton);
		startClicked=menuSheet.crop(9, 124, 275, 110);
		startButtons.add(startClicked);
		exitbutton=menuSheet.crop(319, 8, 239, 110);
		exitButtons.add(exitbutton);
		exitClicked=menuSheet.crop(326, 124, 239, 110);
		exitButtons.add(exitClicked);
		rulesbutton=menuSheet.crop(612, 7, 279, 110);
		ruleButtons.add(rulesbutton);
		rulesClicked=menuSheet.crop(613, 127, 279, 110);
		ruleButtons.add(rulesClicked);
		
		crossedSwords=menuSheet.crop(681, 256, 300, 300);
		title=menuSheet.crop(6, 460, 645, 98);
		
		SpriteSheet capitalSheet= new SpriteSheet(ImageLoader.loadImage("/textures/CAPITALBUTTONS.png"));
		
		player2.add(capitalSheet.crop(25, 24, 360, 120));
		player2.add(capitalSheet.crop(406, 24, 360, 120));
		
		player1.add(capitalSheet.crop(25,159, 360, 120));
		player1.add(capitalSheet.crop(407, 156, 360, 120));
		
		player3.add(capitalSheet.crop(25, 292, 360, 120));
		player3.add(capitalSheet.crop(404, 288, 360, 120));
		
		startgame.add(capitalSheet.crop(25,426, 360, 180));
		startgame.add(capitalSheet.crop(405,426, 360, 180));
		
		SpriteSheet ruleSheet= new SpriteSheet(ImageLoader.loadImage("/textures/BACK.png"));
		
		backButton.add(ruleSheet.crop(14,6, 209, 110));
		backButton.add(ruleSheet.crop(15,130, 209, 110));
	}
	
	public static void redSheets() {
		SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(KVB).png"));
		
		RedRegions.add(sheet.crop(0, 0, 86, 87)); 
		RedRegions.add(sheet.crop(95, 7, 72, 58));
		RedRegions.add(sheet.crop(180, 0, 87, 104));
		RedRegions.add(sheet.crop(274, 0, 114, 100));
		RedRegions.add(sheet.crop(396, 0, 116, 116));
		RedRegions.add(sheet.crop(523, 1, 152, 75));
		RedRegions.add(sheet.crop(693, 6, 62, 85));
		RedRegions.add(sheet.crop(765, 0, 73, 91));
		RedRegions.add(sheet.crop(849, 0, 81, 82));
		
		RedRegions.add(sheet.crop(944, 0, 76, 156));
		RedRegions.add(sheet.crop(1031, 1, 144, 141));
		RedRegions.add(sheet.crop(1190, 0, 101, 107));
		RedRegions.add(sheet.crop(1298, 0, 104, 57));
		
		RedRegions.add(sheet.crop(1412, 0, 83, 85));
		RedRegions.add(sheet.crop(1505, 0, 93, 138));
		RedRegions.add(sheet.crop(1613, 0, 86, 55));
		RedRegions.add(sheet.crop(1709, 2, 43, 70));
		RedRegions.add(sheet.crop(1767, 1, 125, 135));
		RedRegions.add(sheet.crop(0, 112, 95, 118));
		
		RedRegions.add(sheet.crop(114, 120, 63, 78));
		RedRegions.add(sheet.crop(194, 130, 50, 36));
		RedRegions.add(sheet.crop(263, 127, 78, 78));
		RedRegions.add(sheet.crop(366, 131, 77, 91));
		RedRegions.add(sheet.crop(464, 136, 80, 87));
		RedRegions.add(sheet.crop(564, 137, 128, 194));
		RedRegions.add(sheet.crop(726, 142, 69, 97));
		
		RedRegions.add(sheet.crop(822, 148, 97, 102));
		RedRegions.add(sheet.crop(941, 178, 138, 132));
		RedRegions.add(sheet.crop(1099, 176, 102, 145));
		RedRegions.add(sheet.crop(1223, 183, 92, 78));
		RedRegions.add(sheet.crop(1343, 181, 50, 102));
		RedRegions.add(sheet.crop(1424, 166, 122, 146));
		RedRegions.add(sheet.crop(1569, 166, 132, 131)); 
		RedRegions.add(sheet.crop(1725, 175, 104, 81));
		RedRegions.add(sheet.crop(1846, 184, 70, 87)); 
		RedRegions.add(sheet.crop(2, 263, 86, 81));
		RedRegions.add(sheet.crop(116, 263, 74, 155));
		RedRegions.add(sheet.crop(201, 249, 105, 176));
		
		RedRegions.add(sheet.crop(325, 283, 82, 125));
		RedRegions.add(sheet.crop(430, 325, 90, 77));
		RedRegions.add(sheet.crop(570, 368, 68, 54));
		RedRegions.add(sheet.crop(702, 329, 100, 105));
	}
	
	public static void DarkRedSheets() {
		SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(KVB).png"));
		
		RedRegions.add(sheet.crop(2, 458, 86, 87)); 
		RedRegions.add(sheet.crop(114, 473, 72, 58));
		RedRegions.add(sheet.crop(211, 461, 87, 104));
		RedRegions.add(sheet.crop(306, 469, 114, 100));
		RedRegions.add(sheet.crop(436, 466, 116, 116));
		RedRegions.add(sheet.crop(573, 480, 152, 75));
		RedRegions.add(sheet.crop(746, 484, 62, 85));
		RedRegions.add(sheet.crop(828, 482, 73, 91));
		RedRegions.add(sheet.crop(918, 482, 81, 82));
		
		RedRegions.add(sheet.crop(1161, 449, 76, 156));
		RedRegions.add(sheet.crop(1008, 463, 144, 141));
		RedRegions.add(sheet.crop(1250, 472, 101, 107));
		RedRegions.add(sheet.crop(1354, 487, 104, 57));
		
		RedRegions.add(sheet.crop(1461, 487, 83, 85));
		RedRegions.add(sheet.crop(1552, 470, 93, 138));
		RedRegions.add(sheet.crop(1657, 494, 86, 55));
		RedRegions.add(sheet.crop(1746, 494, 43, 70));
		RedRegions.add(sheet.crop(1793, 465, 125, 135));
		RedRegions.add(sheet.crop(3, 581, 95, 118));
		
		RedRegions.add(sheet.crop(112, 591, 63, 78));
		RedRegions.add(sheet.crop(187, 610, 50, 36));
		RedRegions.add(sheet.crop(253, 599, 78, 78));
		RedRegions.add(sheet.crop(342, 602, 77, 91));
		RedRegions.add(sheet.crop(436, 604, 80, 87));
		RedRegions.add(sheet.crop(528, 586, 128, 194));
		RedRegions.add(sheet.crop(675, 594, 69, 97));
		
		RedRegions.add(sheet.crop(763, 595, 97, 102));
		RedRegions.add(sheet.crop(882, 603, 138, 132));
		RedRegions.add(sheet.crop(1050, 616, 102, 145));
		RedRegions.add(sheet.crop(1172, 636, 92, 78));
		RedRegions.add(sheet.crop(1279, 632, 50, 102));
		RedRegions.add(sheet.crop(1353, 622, 122, 146));
		RedRegions.add(sheet.crop(1491, 625, 132, 131)); 
		RedRegions.add(sheet.crop(1639, 635, 104, 81));
		RedRegions.add(sheet.crop(1751, 636, 70, 87)); 
		RedRegions.add(sheet.crop(1831, 640, 86, 81));
		RedRegions.add(sheet.crop(8, 744, 74, 155));
		RedRegions.add(sheet.crop(84, 727, 105, 176));
		
		RedRegions.add(sheet.crop(197, 741, 82, 125));
		RedRegions.add(sheet.crop(299, 765, 90, 77));
		RedRegions.add(sheet.crop(413, 777, 68, 54));
		RedRegions.add(sheet.crop(500, 787, 100, 105));
	}
	
	public static void blueSheets() {
		SpriteSheet sheetB=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(Blue).png"));
		
		BlueRegions.add(sheetB.crop(6,4,85,88));
		BlueRegions.add(sheetB.crop(105,11, 75,61));
		BlueRegions.add(sheetB.crop(196,11, 87,105));
		BlueRegions.add(sheetB.crop(305,16, 118,102));
		BlueRegions.add(sheetB.crop(446,12, 116,118));
		BlueRegions.add(sheetB.crop(593,16, 148,71));
		BlueRegions.add(sheetB.crop(786,20, 62,85));
		BlueRegions.add(sheetB.crop(880,16, 77,95));
		BlueRegions.add(sheetB.crop(982,13, 85,86));
		
		BlueRegions.add(sheetB.crop(1111,11,78,158));
		BlueRegions.add(sheetB.crop(1232,8, 147,143));
		BlueRegions.add(sheetB.crop(1413,16, 103,108));
		BlueRegions.add(sheetB.crop(1539,22, 105,59));
		
		BlueRegions.add(sheetB.crop(1657,15,87,87));
		BlueRegions.add(sheetB.crop(1773,17, 97,142));
		BlueRegions.add(sheetB.crop(9,154, 88,58));
		BlueRegions.add(sheetB.crop(124,153, 46,72));
		BlueRegions.add(sheetB.crop(202,151, 128,139));
		BlueRegions.add(sheetB.crop(358,153,98,121));
		
		BlueRegions.add(sheetB.crop(480,156, 65,80));
		BlueRegions.add(sheetB.crop(554,161, 51,37));
		BlueRegions.add(sheetB.crop(622,157, 82,82));
		BlueRegions.add(sheetB.crop(723,153, 81,95));
		BlueRegions.add(sheetB.crop(836,156, 83,91));
		BlueRegions.add(sheetB.crop(955,161, 128, 194));
		BlueRegions.add(sheetB.crop(1116,175, 71,99));
		
		BlueRegions.add(sheetB.crop(1213,174, 99,104));
		BlueRegions.add(sheetB.crop(1338,167, 139,134));
		BlueRegions.add(sheetB.crop(1511,164, 102, 145));
		BlueRegions.add(sheetB.crop(1623,171, 92, 78));
		BlueRegions.add(sheetB.crop(1730,170, 50, 102));
		BlueRegions.add(sheetB.crop(1791,171, 124,148));
		BlueRegions.add(sheetB.crop(16,295, 132, 131)); 
		BlueRegions.add(sheetB.crop(175,299, 104, 81));
		BlueRegions.add(sheetB.crop(298,300, 70, 87)); 
		BlueRegions.add(sheetB.crop(394,300, 86, 81));
		BlueRegions.add(sheetB.crop(505,299, 74, 155));
		BlueRegions.add(sheetB.crop(584,284, 107,176));
		
		BlueRegions.add(sheetB.crop(700,307, 82, 125));
		BlueRegions.add(sheetB.crop(808,312, 90, 77));
		BlueRegions.add(sheetB.crop(918,346, 68, 54));
		BlueRegions.add(sheetB.crop(1078,333, 100, 105));
	}
	
	public static void darkBlueSheets() {
		SpriteSheet sheetB=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(Blue).png"));

		BlueRegions.add(sheetB.crop(20,493,85,88));
		BlueRegions.add(sheetB.crop(123,500, 75,61));
		BlueRegions.add(sheetB.crop(221,492, 87,105));
		BlueRegions.add(sheetB.crop(321,500, 118,102));
		BlueRegions.add(sheetB.crop(461,497, 116,118));
		BlueRegions.add(sheetB.crop(598,501, 148,71));
		BlueRegions.add(sheetB.crop(761,501, 62,85));
		BlueRegions.add(sheetB.crop(832,499, 77,95));
		BlueRegions.add(sheetB.crop(923,503, 85,86));
		
		BlueRegions.add(sheetB.crop(1029,502,78,158));
		BlueRegions.add(sheetB.crop(1134,504, 147,143));
		BlueRegions.add(sheetB.crop(1297,501, 103,108));
		BlueRegions.add(sheetB.crop(1405,505, 105,59));
		
		BlueRegions.add(sheetB.crop(1530,500,87,87));
		BlueRegions.add(sheetB.crop(1632,503, 97,142));
		BlueRegions.add(sheetB.crop(1741,506, 88,58));
		BlueRegions.add(sheetB.crop(1848,511, 46,72));
		BlueRegions.add(sheetB.crop(23,616, 128,139));
		BlueRegions.add(sheetB.crop(174,618,98,121));
		
		BlueRegions.add(sheetB.crop(296,630, 65,80));
		BlueRegions.add(sheetB.crop(383,639, 51,37));
		BlueRegions.add(sheetB.crop(455,639, 82,82));
		BlueRegions.add(sheetB.crop(547,636, 81,95));
		BlueRegions.add(sheetB.crop(644,637, 83,91));
		BlueRegions.add(sheetB.crop(747,637, 128, 194));
		BlueRegions.add(sheetB.crop(907,634, 71,99));
		
		BlueRegions.add(sheetB.crop(1000,666, 99,104));
		BlueRegions.add(sheetB.crop(1120,666, 139,134));
		BlueRegions.add(sheetB.crop(1277,657, 102, 145));
		BlueRegions.add(sheetB.crop(1399,660, 92, 78));
		BlueRegions.add(sheetB.crop(1505,662, 50, 102));
		BlueRegions.add(sheetB.crop(1577,661, 124,148));
		BlueRegions.add(sheetB.crop(1716,664, 132, 131)); 
		BlueRegions.add(sheetB.crop(24,794, 104, 81));
		BlueRegions.add(sheetB.crop(147,791, 70, 87)); 
		BlueRegions.add(sheetB.crop(235,796, 86, 81));
		BlueRegions.add(sheetB.crop(351,798, 74, 155));
		BlueRegions.add(sheetB.crop(431,782, 107,176));
		
		BlueRegions.add(sheetB.crop(547,806, 82, 125));
		BlueRegions.add(sheetB.crop(647,831, 90, 77));
		BlueRegions.add(sheetB.crop(753,842, 68, 54));
		BlueRegions.add(sheetB.crop(835,839, 100, 105));
	}
	
	public static void Yellowsheets() {
		SpriteSheet sheetY=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(Yellow).png"));

		YellowRegions.add(sheetY.crop(23,16,85,88));
		YellowRegions.add(sheetY.crop(132,19, 73,59));
		YellowRegions.add(sheetY.crop(235,22, 87,105));
		YellowRegions.add(sheetY.crop(347,30, 116,100));
		YellowRegions.add(sheetY.crop(482,22, 116,118));
		YellowRegions.add(sheetY.crop(632,35, 148,71));
		YellowRegions.add(sheetY.crop(810,43, 64,82));
		YellowRegions.add(sheetY.crop(902,29, 75,93));
		YellowRegions.add(sheetY.crop(1006,35, 83,84));
		
		YellowRegions.add(sheetY.crop(1123,14, 77,156));
		YellowRegions.add(sheetY.crop(1226,16, 145,141));
		YellowRegions.add(sheetY.crop(1401,25, 102,107));
		YellowRegions.add(sheetY.crop(1572,56, 104,58));
		
		YellowRegions.add(sheetY.crop(1690,46,85,86));
		YellowRegions.add(sheetY.crop(1802,31, 95,140));
		YellowRegions.add(sheetY.crop(31,219, 87,56));
		YellowRegions.add(sheetY.crop(141,213, 44,71));
		YellowRegions.add(sheetY.crop(223,189, 126,137));
		YellowRegions.add(sheetY.crop(393,198, 96,119));
		
		YellowRegions.add(sheetY.crop(527,231, 64,79));
		YellowRegions.add(sheetY.crop(622,252, 50,36));
		YellowRegions.add(sheetY.crop(703,234, 80,80));
		YellowRegions.add(sheetY.crop(826,229, 79,93));
		YellowRegions.add(sheetY.crop(953,223, 81,89));
		YellowRegions.add(sheetY.crop(1072,192, 128, 194));
		YellowRegions.add(sheetY.crop(1249,223, 70,99));
		
		YellowRegions.add(sheetY.crop(1363,216, 98,104));
		YellowRegions.add(sheetY.crop(1512,198, 139,134));
		YellowRegions.add(sheetY.crop(1694,192, 102, 145));
		YellowRegions.add(sheetY.crop(1819,221, 92, 78));
		YellowRegions.add(sheetY.crop(54,405, 50, 102));
		YellowRegions.add(sheetY.crop(153,381, 124,148));
		YellowRegions.add(sheetY.crop(303,389, 132, 131)); 
		YellowRegions.add(sheetY.crop(467,397, 104, 81));
		YellowRegions.add(sheetY.crop(590,399, 70, 87)); 
		YellowRegions.add(sheetY.crop(684,398, 86, 81));
		YellowRegions.add(sheetY.crop(802,376, 74, 155));
		YellowRegions.add(sheetY.crop(893,361, 107,176));
		
		YellowRegions.add(sheetY.crop(1022,396, 82, 125));
		YellowRegions.add(sheetY.crop(1148,417, 90, 77));
		YellowRegions.add(sheetY.crop(1267,425, 68, 54));
		YellowRegions.add(sheetY.crop(1367,399, 100, 105));
	}
	
	public static void DarkYellowsheets() {
		SpriteSheet sheetY=new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet(Yellow).png"));

		YellowRegions.add(sheetY.crop(42,567,85,88));
		YellowRegions.add(sheetY.crop(159,576, 73,59));
		YellowRegions.add(sheetY.crop(267,560, 87,105));
		YellowRegions.add(sheetY.crop(367,578, 116,100));
		YellowRegions.add(sheetY.crop(490,572, 116,118));
		YellowRegions.add(sheetY.crop(620,556, 148,71));
		YellowRegions.add(sheetY.crop(798,559, 64,82));
		YellowRegions.add(sheetY.crop(878,553, 75,93));
		YellowRegions.add(sheetY.crop(983,557, 83,84));
		
		YellowRegions.add(sheetY.crop(1131,519, 77,156));
		YellowRegions.add(sheetY.crop(1252,534, 145,141));
		YellowRegions.add(sheetY.crop(1451,559, 102,107));
		YellowRegions.add(sheetY.crop(1577,580, 104,58));
		
		YellowRegions.add(sheetY.crop(1696,556, 85,86));
		YellowRegions.add(sheetY.crop(1790,529, 95,140));
		YellowRegions.add(sheetY.crop(46,762, 87,56));
		YellowRegions.add(sheetY.crop(165,761, 44,71));
		YellowRegions.add(sheetY.crop(232,737, 126,137));
		YellowRegions.add(sheetY.crop(408,752, 96,119));
		
		YellowRegions.add(sheetY.crop(534,779, 64,79));
		YellowRegions.add(sheetY.crop(632,792, 50,36));
		YellowRegions.add(sheetY.crop(716,758, 80,80));
		YellowRegions.add(sheetY.crop(855,753, 79,93));
		YellowRegions.add(sheetY.crop(971,747, 81,89));
		YellowRegions.add(sheetY.crop(1085,688, 128,194));
		YellowRegions.add(sheetY.crop(1238,751, 70,99));
		
		YellowRegions.add(sheetY.crop(1355,750, 98,104));
		YellowRegions.add(sheetY.crop(1497,746, 139,134));
		YellowRegions.add(sheetY.crop(1663,738, 102, 145));
		YellowRegions.add(sheetY.crop(1802,773, 92, 78));
		YellowRegions.add(sheetY.crop(65,917, 50, 102));
		YellowRegions.add(sheetY.crop(180,891, 124,148));
		YellowRegions.add(sheetY.crop(330,897, 132, 131)); 
		YellowRegions.add(sheetY.crop(480,907, 104, 81));
		YellowRegions.add(sheetY.crop(592,923, 70, 87)); 
		YellowRegions.add(sheetY.crop(696,926, 86, 81));
		YellowRegions.add(sheetY.crop(829,886, 74, 155));
		YellowRegions.add(sheetY.crop(921,868, 107,176));
		
		YellowRegions.add(sheetY.crop(1051,896, 82, 125));
		YellowRegions.add(sheetY.crop(1171,927, 90, 77));
		YellowRegions.add(sheetY.crop(1284,939, 68, 54));
		YellowRegions.add(sheetY.crop(1386,919, 100, 105));
	}
}
