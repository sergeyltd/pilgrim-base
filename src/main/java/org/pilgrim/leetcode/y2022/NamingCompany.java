package org.pilgrim.leetcode.y2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NamingCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(distinctNames(new String[] { "coffee", "donuts", "time", "toffee" }));
		System.out.println(distinctNames2(new String[] { "coffee", "donuts", "time", "toffee" }));
		run();
	}

	public static void run() {

		System.out.println(distinctNames(new String[] { "soth", "jas", "ucgtuwdwu", "ceixwz", "wzmzsx", "qxrknsmmjo",
				"dpmrb", "fcfjetd", "hmikcwh", "xcpauje", "mznzbvjf", "rumlsg", "ahg", "ncannzvpv", "abyvbfgpa",
				"nmpeswpvan", "sbk", "wrqr", "qzhxtcfct", "nyddvtevt", "duy", "ugelaxqtk", "mdm", "dknabpkq", "ixac",
				"xvhsoem", "ytovbripfo", "wpbv", "plzcixmx", "fmd", "bgfib", "tidqu", "bpj", "deh", "teopxlwzub",
				"qjeff", "vuiks", "bhtgkqujb", "ksaahbxk", "hykvwt", "lbnyztptaz", "tijakxr", "cqnu", "ivq", "yzvpfar",
				"siwz", "imqncdpwu", "vdf", "blmnutrovy" }));
		System.out.println(distinctNames2(new String[] { "soth", "jas", "ucgtuwdwu", "ceixwz", "wzmzsx", "qxrknsmmjo",
				"dpmrb", "fcfjetd", "hmikcwh", "xcpauje", "mznzbvjf", "rumlsg", "ahg", "ncannzvpv", "abyvbfgpa",
				"nmpeswpvan", "sbk", "wrqr", "qzhxtcfct", "nyddvtevt", "duy", "ugelaxqtk", "mdm", "dknabpkq", "ixac",
				"xvhsoem", "ytovbripfo", "wpbv", "plzcixmx", "fmd", "bgfib", "tidqu", "bpj", "deh", "teopxlwzub",
				"qjeff", "vuiks", "bhtgkqujb", "ksaahbxk", "hykvwt", "lbnyztptaz", "tijakxr", "cqnu", "ivq", "yzvpfar",
				"siwz", "imqncdpwu", "vdf", "blmnutrovy" }));

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			distinctNames(new String[] { "qyrsjqf", "npkwrvpw", "sr", "dvvddivf", "swpqw", "gde", "xfthxrdrvr",
					"juxigiv", "dxac", "lrahacr", "bpkfkkim", "lmmcyhmf", "knirgdz", "dhkntz", "gtmctc", "ztm",
					"kgsxfiqk", "iwqxls", "dentvnwpf", "fflfbw", "nyhmwkqy", "nnsr", "kpfjxaa", "fmp", "bp",
					"ilvjonvtx", "nevsdb", "pymgvwxie", "prvhi", "koolvw", "kjxnluc", "fbjby", "aqhyjobtxh", "qxb",
					"axalyokepd", "hbywdxsupd", "kezpeq", "ckahdikh", "cxsqm", "poxfgzdr", "qawwouccu", "nwo", "bzp",
					"chujtykq", "aqcpkaqf", "fgkz", "thvlpru", "fkbkwc", "wekwrujgje", "eigqtdjrj", "lzv", "nkuxhyeqdl",
					"sywbvi", "rwqbiefgy", "jsl", "aygvuwjwc", "ooghaxku", "fnwgp", "msqpdnsnx", "fpspkb", "etsiyudio",
					"gcst", "olfca", "vp", "kyklq", "gxxss", "cnujfvjawf", "toe", "uhjajlx", "ugmne", "ehtv", "crgrjdx",
					"tjyjqkfgrm", "zcmpbxcs", "ovg", "munepcdlgm", "trgrdnay", "qplsni", "lxffjpzvwt", "xnbatnn", "fcm",
					"xhmaatbj", "lgjuqvyxdu", "gcfnhp", "nfcfqwu", "yoxqyzbdz", "urmrlfgu", "nxeg", "uwpqw", "nrnmljlk",
					"joc", "fybem", "nhqw", "grdkrj", "edzyxivptf", "yhrwvh", "rxvjrhzju", "rh", "qeomu", "zulhtc",
					"rgb", "kuomkacx", "yuo", "pbyuaof", "pqcdtnnt", "pmahdqpav", "ybkailmtl", "nptwdmdqc", "tkxy",
					"fmixd", "vwpt", "sodqs", "teuahbuh", "krycwlacvp", "ubdekyqq", "tfwzjac", "sldsnlyz", "waxg",
					"fvezyktac", "dhozhrqo", "qpluqel", "zjsxro", "snzp", "qjql", "fo", "cfwzjac", "axx", "damwbpmnfw",
					"gyemxvmk", "dklrjcta", "wgtakz", "fxamrpksb", "tdnihkqvz", "lqjbvz", "qpwpkgp", "uruk", "gpwl",
					"vdxcwchir", "sybps", "wmsmsnpr", "uvvgpdixci", "otu", "vroand", "klsfvjfmfu", "yma", "lbhywilh",
					"nvuhvfy", "ns", "gcehop", "wbgzfjnp", "nhe", "tyept", "dqy", "lop", "ozonsqu", "bzn", "blxgp",
					"lxyzr", "uuvepvw", "gbzpbqwapt", "nggdoivw", "hvk", "xyv", "dtcjn", "rqf", "epobzvdvt", "nxxss",
					"bawbijga", "kglt", "wnxwjk", "wfvngozni", "byxajgdhq", "oimjinoz", "jzeq", "jcvfjmt", "ozvmmmn",
					"xdydx", "bcpzizufrz", "msfclryn", "zqvh", "dfizi", "ricrfefchc", "prhrtud", "ooho", "eex", "uky",
					"epeoku", "dqqgnx", "fxrt", "rtpn", "ttmsnkvfn", "oraw", "yivuxmr", "quaod", "jvdm", "zggw",
					"fcqknmbg", "saztfv", "xqqgnx", "sevxnkau", "szcpujmukh", "azkusw", "uphaaqz", "lwt", "egczle",
					"oqhwbz", "mtiaukam", "nhvoyijqvr", "spxwic", "lni", "huhlgucd", "fexrf", "ule", "xfopjkbnk",
					"hdtgt", "kersenxw", "rggqwfvjtx", "tzfbfvops", "btqqpvx", "vtax", "qqpljw", "sgjtljxfs",
					"exikwbzdqn", "wqo", "sgtr", "amblqp", "zlnuw", "ehn", "fbcjifximy", "ipmrb", "tcgwxtcouz",
					"zxaudcn", "ggpiyjm", "wqtp", "kphxkhzt", "eawwouccu", "fumpqohi", "uevh", "npgundthg", "uznjpqmaw",
					"jho", "mdofqikf", "burpocyfz", "xxox", "lzeq", "nu", "yguxkuzi", "jnwavpbiqe", "bhdxdaf",
					"lyvilxdt", "oljiyosb", "ltgb", "kxnz", "hpukujk", "gcfboi", "gaktajlyda", "xsvjvvzuly", "flnliopr",
					"stgcl", "uaqcoo", "vf", "qaztfv", "oypfqoa", "ewwfixmkt", "jvpldq", "hsfsjkw", "guvqej", "wcep",
					"xdkztmrsp", "mc", "jexrpmcibv", "qspsxinmda", "qwwkdyugq", "pkrmavvgu", "nyrsjqf", "npq", "udilq",
					"chawer", "ecxqdxz", "hq", "zubltv", "vdtljiitec", "xefchsvu", "eqkn", "oiyd", "rvteyyst", "zo",
					"hwcqzz", "nrvdpcltov", "yoptagh", "slgdontkso", "hpruzn", "rgmywgmg", "gbyf", "iutmkeyco",
					"itfpqnf", "xdvhlojb", "gtobi", "ykhndtp", "gszbw", "eclrd", "qneuh", "oejsrh", "tarvece",
					"bbwuvek", "jiribvugg", "xvlhkidaj", "hqljksfj", "qtka", "xhsxpggbjx", "jbuchru", "di",
					"xvvbuwripj", "gqiqxu", "yysgcpqin", "mzzoxrbff", "dqkqw", "vpu", "jpuyrfhxf", "bf", "iwmr",
					"inmtkyx", "ekucnjeqj", "xzb", "dbwgcb", "uaegtssg", "mnmvfryohx", "ytg", "upaimxold", "qtefec",
					"ugzppq", "kzddqp", "vppkuejvt", "sxjqv", "drefdtze", "mrovxam", "rwlwaz", "knur", "wwyfpzh",
					"vqhjt", "gbrwx", "kkahdikh", "fpjvf", "lerbhb", "bit", "xyjgm", "pyydfqs", "lhqsazkv",
					"lslrfnjiyl", "tuv", "bteuumdqtv", "zgfwe", "qvpagasiz", "xzubqvkh", "fzy", "kxmdez", "ldze",
					"lkjkvs", "nqbnoqqulo", "phtispt", "eyn", "vrblyvktmx", "gvju", "biulxdzovh", "nrdfwh", "qmecq",
					"dpwlbjgx", "yrhqsvm", "scx", "imdcnnew", "hlueo", "ryhmwkqy", "knwsj", "hdnwtmz", "jxxwsdijb",
					"gddh", "mhdggdzcsm", "temhscud", "buoqogkvs", "rbvvph", "xaslicd", "agl", "qagqmzucou", "haoqxyqz",
					"czcpdzq", "zumga", "kwkex", "duvjqcgtin", "liuluppyo", "yublbnogy", "lytmyolobk", "siywcrcbj",
					"sqbvvaf", "iwug", "cdqiuzh", "xek", "uauzb", "zdnihkqvz", "lxv", "ccnr", "argwpcuf", "tyzlzex",
					"ru", "yehzminwwn", "wyr", "uxkzajn", "mejhtqae", "qiilbepkr", "izznvsj", "kvgzo", "abd", "kwupuzp",
					"lipylydc", "lxac", "dcwtfjumg", "glndsssfjc", "odzvwxyubh", "orbdlrriis", "bedrjigyt",
					"oxnttgjlzy", "mjq", "dhzrzcne", "lrapm", "fdlrolzu", "gsa", "akblvoa", "epaksd", "rbssske", "jnv",
					"vhvlpru", "qhah", "oolk", "uilpeztrrq", "aeelfiry", "wivbgemsb", "yoigtqnwqh", "ieypamhcq",
					"tsxke", "edeun", "fkjutjguwp", "evxaec", "ibugw", "ukujj", "klwgh", "ktbyq", "sznlaeer", "nbhfsjt",
					"gvsnx", "qpbdazu", "noebyfv", "loisay", "imgzbkc", "whgfk", "ukhctrhi", "dnv", "uxsmb",
					"ozfzpkwjnl", "dretiqh", "errrbze", "qwd", "vzaeqxbqb", "nuv", "halmb", "igm", "yjsqketzc",
					"icvilrxpos", "kirycsvb", "zsuznof", "xus", "xbuspsa", "fg", "lmyzounckw", "bdvmev", "teafya",
					"zus", "mihdmdfwr", "ciwn", "betdtajmg", "tcolpljf", "dgssqe", "uvrbnf", "pozoenu", "tybc",
					"rhphtc", "lzpxktwkf", "uqctfth", "uiyw", "ubdarctj", "sfitb", "jrygtv", "fttsva", "xrdjnlgi",
					"vtpxnxy", "lgakilcrv", "jilzwpvr", "tcifccmssq", "gtrid", "bujgpbf", "txjn", "wcy", "kqcijvj",
					"krxboecrc", "ayptbrrysu", "preq", "ujvnvro", "wesovpctyg", "ebzxcm", "zgbavjvaa", "gcbca",
					"vvhscl", "lji", "kg", "egsqiv", "fuggcnw", "mdftciw", "vwzn", "cie", "xyept", "kclidoj", "hkieusm",
					"wnih", "akbbgucav", "kep", "whutueson", "vwixzjcpnd", "cu", "kvjrkeg", "umyunzlfiw", "lbf",
					"chpopdi", "bacygumq", "fdkztmrsp", "yzbwf", "mbwfagabon", "oaoimyqq", "dnmtkyx", "yuovn", "cgsqiv",
					"aryjbbs", "hdpwmxc", "gtwocdlcl", "tgt", "fqdfuzwx", "olva", "ucwxwo", "gmprusqod", "eibr",
					"bpbvdud", "wb", "vfqxylhrkr", "mhxzfe", "dnkqfjjqpk", "eqmthwzctm", "gfijudvys", "badtnfswv",
					"raslicd", "vpfem", "mexgwqgqh", "bhtcuhte", "qic", "lgdli", "poqekeafm", "qhtwrxiibu",
					"jvmmxdvylt", "qwtnclzqnr", "zsyjild", "fweyoq", "fp", "uohzkxvf", "czdvb", "exri", "enaeol",
					"onlakowthc", "xja", "gibcvlmmh", "ixafda", "vqhndhd", "txttmhcouq", "drrbzr", "bbgcu",
					"ntmqvvisul", "vzc", "wbmg", "xyirbu", "uzfzpkwjnl", "xnkl", "htkh", "rzzwgq", "lsq", "ph",
					"rueolhy", "ttwnbbheeg", "kqofyyq", "rmkfk", "ebksm", "iqzbqegkd", "kyipjxkxvq", "szvc",
					"hywfvajuy", "olfp", "jkazzyx", "utovm", "tfwzxbrpy", "yg", "bcoiajzt", "jpwjmjgr", "baqtb",
					"dcoiajzt", "imiidi", "jjgfnqnqk", "xevcbv", "evrwjqtdhd", "zfdlh", "auqxvtf", "ylrltfl", "xrwyybr",
					"xpalkxatmz", "ogxrxsphn", "upjvf", "uibov", "rlych", "vulabbdjhm", "vebl", "tiyhxjx", "nycozdxlu",
					"dsa", "qrymazijmp", "mbs", "hejo", "tysljjdjti", "huljn", "lsie", "wtnwnnvr", "itilfthq",
					"hdtilpp", "sdmxpaso", "cudrof", "sydztlc", "zxt", "tjf", "xibck", "btpij", "ucws", "ibku", "tohx",
					"gbyvtr", "zdw", "oysp", "pgqcupx", "eozuc", "jwpyoimvng", "foso", "oefchsvu", "awoo", "rwc",
					"mlolzxdmns", "klgdontkso", "zyjzb", "kkosyio", "exac", "bcfeawureu", "spmrb", "yxyzr",
					"jwogogedqf", "eetbflrpif", "elfdcfsbo", "xchkhqwgh", "hhs", "koe", "lrcsssy", "adljehijd", "tjuz",
					"xehzminwwn", "knqswif", "zhppqzhrfn", "tgdryzpp", "lftrjupjy", "eothz", "pekizk", "ubacrf",
					"ubgcu", "uxkvlezwc", "bhzmlijkii", "hvayzv", "eguteh", "zxrinu", "ciyhxjx", "in", "xvqfjhfry",
					"tdjq", "cppkaef", "ooukycmgc", "qaytva", "zzec", "ttp", "btgeoimmwg", "xzawov", "ykj", "onwgp",
					"wreuw", "yyvhdvf", "czvmavvp", "pfgvz", "xc", "mbddieqgj", "jfayqxxw", "evivvfxr", "vlocqsfxh",
					"sbapflgi", "ivwud", "ucuvle", "pxtm", "rjgsywq", "psdxg", "anl", "lskdvgqump", "orefdtze",
					"oxdrwj", "xuzsskz", "afgfhpfxsx", "niti", "lyisbpw", "wakvqfcr", "nqbtmo", "lrdfwh", "aopoazri",
					"fmimjvh", "varjohqm", "yar", "na", "brmrlfgu", "pgdxefhj", "sprolyhylz", "dyf", "igjf", "nutvn",
					"bsst", "ijtlqgw", "fhjajlx", "cwvak", "hzdve", "fuixtmztvs", "qtpfovago", "npuwabxf", "rbgcu",
					"zuqwfqz", "snpyychl", "wqcdtnnt", "sifmk", "cyorvkzy", "jnkqfjjqpk", "aunlw", "uqvge", "qdsyk",
					"hikhufl", "ckahtfgc", "aitfy", "noza", "cxfnbdtw", "mypddn", "ufyd", "jcf", "jgpovk", "kvv",
					"lpblwiurfv", "fwftxr", "teockxldsc", "ixdfqugxt", "fvg", "tmeec", "giywinxvho", "ovaelaxv",
					"hjdfdgeii", "yqstdrucuk", "otthclky", "vn", "bgpitppo", "mvo", "cltp", "dil", "xnb", "kccpa", "rk",
					"xiondaeish", "elvqwr", "aqbifrhx", "sfqlepxnge", "qbwfewxalz", "topos", "tiajycvqvh", "unlakowthc",
					"djfjq", "oph", "ornr", "itqiafwr", "qreeavecar", "teapuylykf", "vvvcn", "tr", "btmptq", "cfpvh",
					"depevx", "makvqfcr", "epnpqiz", "ahshk", "wryjbbs", "exhrk", "qohqwhiyjs", "unb", "zcp", "cqobnx",
					"iib", "iecbupczks", "gubnyfsywv", "fgpiusmic", "zbir", "jogzk", "hivbgemsb", "yvzht", "btilfthq",
					"jivbgemsb", "zzngvfya", "ijgcpnfvu", "ehpopdi", "feql", "ejhxexthhi", "zypcokdblb", "ilbgd",
					"rjbkrzma", "wvsbilano", "uyewnu", "dcckjdt", "qrkcvis", "kvbbgyov", "koukmpqw", "ndwhpejxyv",
					"iqhwpjs", "ftaomrqe", "mwibxbbb", "ezzrrx", "hjhenzwea", "gxbtnj", "cufftag", "rkwcjcv",
					"rgbenqtja", "hxno", "xocymnskkm", "xcfojdr", "hrhaatvaq", "hgaqq", "cvj", "gfdmadjq", "kew",
					"tlsflkvit", "qgmtopcvf", "hpfskkz", "dxdvantsnt", "xqoy", "nefoy", "lmtcqptp", "eflox", "qgzxbn",
					"ifot", "czpxchqc", "tvkhvjtkn", "rpnbjni", "fdlfbho", "kmarkhdbz", "gxjau", "hmbjhaawtp",
					"sbwhunlmz", "jxqtgc", "bgzfmmhlz", "zgagg", "xppnkuzugk", "kstqfhgzu", "ytkqrie", "uryhskf",
					"qewwpeav", "ugubcuzhx", "twfbqtuqha", "hdf", "eqdm", "nqyp", "rgj", "ngajyj", "ufzxk", "vqoy",
					"zqobnx", "ijhkp", "ypdspv", "gwfzyamz", "geurvenewl", "siyhxjx", "oaq", "ukzanp", "koxo",
					"intrgwip", "lrgotgia", "gidhoqtce", "xtvjx", "cztfdvxf", "hoodipmzou", "bbssykqjx", "xnl", "lkl",
					"hdyierkbf", "gfvk", "pcolpljf", "xslrfnjiyl", "beyzb", "xeeum", "nrfnga", "pttj", "btn",
					"pmfeebdxeg", "atvbsrazai", "kluvlvldz", "wxpzl", "hhogxrklii", "riwn", "btyrfmlvvz", "rsecpdchl",
					"mvjcc", "fsfnjnogwb", "xqry", "gjmu", "pzlesb", "ejyejx", "bzotkr", "wrjlhyccme", "bozhoofxu",
					"ctdrj", "kis", "cikhufl", "hlar", "pry", "zsxke", "agb", "zvrwjqtdhd", "grwt", "dqmflj", "yvizzy",
					"qzipq", "sofhlvf", "waijidrqz", "lwfphjmipv", "kzfzpkwjnl", "jxq", "guuancqhqu", "oqcgm",
					"geoksuqohu", "cdsijcvp", "umnrm", "vkirl", "bhklwyeyta", "mjyuvlwq", "nuubqu", "samhh", "khd",
					"akyuowqb", "zmmiih", "ixayge", "wurgikmah", "tdb", "mjkbuh", "xzvpfar", "tgmq", "cikfvcvkhm",
					"bdbteaxdyc", "xiqqsij", "xqtftp", "tobe", "wkxtatqpsr", "tcsuxuxt", "tpj", "hjkrnf", "nhqwrml",
					"zjmw", "admseaqdii", "id", "emqzz", "jgpiyjm", "qujq", "dz", "owoi", "wxiqt", "hsgbcbwsi",
					"wxbloijch", "gkqtkv", "nppe", "ltux", "mfynwp", "ozqzp", "znbatnn", "usfclryn", "oma", "sknz",
					"xww", "sgoje", "xotjx", "vrpmvarguv", "jeployof", "zvwf", "wzlakkcn", "an", "fso", "qeapofdkr",
					"es", "wvvyzldfe", "rxbijjbflj", "noahkz", "cupgee", "ntarmbl", "dlv", "bzpj", "oaqpwffjv", "fn",
					"nwzkgbxnp", "ejdrh", "vkfwu", "qujcw", "lxbxoktuu", "gqbiry", "blymibrawk", "mjla", "eamhuetv",
					"hrr", "vpmrpvlkk", "txjnyugvv", "ligwxosjn", "mhzfrios", "yxmoa", "gdufon", "lxss", "rtzy",
					"ckbrahsgv", "wrwrlrfdjx", "mqeyxge", "vgs", "eeswapqhd", "rambxfbfa", "bunterqryf", "cphkoqfhi",
					"hvyjtm", "magekeu", "ha", "pwboogv", "cpxofjvsk", "krpom", "nzqw", "oo", "pxhmzbd", "pgr",
					"uttkny", "we", "mwrntwlx", "dyp", "pfiyk", "ysandj", "meqs", "luvlljpgym", "muj", "vjuz",
					"dxdbugvzye", "ga", "kjza", "adkiebv", "wn", "xgehuwshgu", "ctsy", "zwypu", "ruxpxuo", "gmvmquk",
					"eoummzcb", "pydo", "avauh", "drzw", "zldlhiuouh", "hlrchrxtyw", "yv", "qs", "fndpg", "injukdw",
					"cbjktjmo", "wjznw", "yeohuozv", "pcicfcxoo", "bjanq", "jpds", "vqdfuzwx", "uurayjfuy", "imcobjbv",
					"omvisomcg", "siyjm", "yffc", "fkmbzcn", "oixyhiwfxt", "uenmzrz", "jvhx", "tigqtdjrj", "paimepcpb",
					"nppdudu", "czmcyyp", "wtax", "nlibwmrsh", "kvzblbruo", "wazvd", "pex", "wphkz", "dlvqwr",
					"awiffulqg", "jr", "nob", "qhvlpru", "pws", "iycbsvlm", "chqlt", "szcpdzq", "wcymmkmrz", "vrvcqygt",
					"nwcxpjn", "wvbyscdtny", "hnihuyprje", "srzuwcnee", "mldczcp", "bgna", "wwojwy", "btpfovago",
					"apbv", "mppiiozlpl", "izzmhm", "zkjbbcf", "ptegjm", "aqy", "piob", "ihf", "shst", "ugpfsovpk",
					"yemgvlm", "okdrqxvle", "wgp", "wm", "gzlmnb", "uygvuwjwc", "dveu", "ivo", "ahxzfe", "erdmaxl",
					"kmnydezhw", "xugkdfcdz", "oevyi", "jikudf", "dmmtrthkrs", "bbrif", "pjxijpxrb", "sznzbvjf",
					"bstwh", "daangsrk", "woqouco", "cxalyokepd", "yvjvijlq", "twfnwwsxgr", "mglmwhfldv", "utmzqjaw",
					"qpwqizx", "jbmwo", "wqnvbywwf", "zodrjbcr", "iof", "dpwqizx", "raimepcpb", "rebnrhussj",
					"cyflclaeii", "enw", "agjf", "vknabpkq", "ai", "waw", "ugado", "tphxkhzt", "pjid", "yfq", "latb",
					"wgdli", "clatr", "wmahdqpav", "otpgp", "fzz", "hrhrakxk", "xigqieyi", "pvvzh", "bdvhfnmz",
					"fnumsmm", "nvv", "gbekr", "zimjinoz", "zjnmvv", "yfpvh", "ek", "sjfr", "datykl", "hxddnsz",
					"otumwuhd", "nemvcft", "zrb", "bwu", "dywbhvdq", "hrcup", "fefoy", "ukg", "ypq", "vee", "dayyarvi",
					"kxur", "tvilrjjfw", "dabsyzvlao", "qtkqeqw", "vxykjig", "xtlxklc", "bgpyx", "ovjqsth", "gkm",
					"wzhmrnwz", "nhg", "hjqln", "tyzxz", "mkoiolgm", "nnhwzt", "rjaft", "tmlxles", "goyzjywavw", "dbi",
					"eexn", "axsnceluc", "afpahltxr", "bylny", "isoxukq", "ial", "hxhiiruko", "ecko", "ldn", "pwaarhql",
					"epaimxold", "ekviahdmn", "ja", "efqrya", "cnaeh", "tovf", "kdgsvn", "ovnzl", "jrnr", "jatb",
					"yvdm", "gywyfxozyw", "vbhywilh", "rbaujr", "akvvlcf", "ylrwrao", "jeimrt", "elcwqgxky", "oqfngcs",
					"mtyu", "gdsujzj", "ffshjoht", "gzkom", "sfuqq", "itr", "ofrzorx", "utwgxwr", "vptuslikp", "lsdxg",
					"xzcnccrafk", "lwwwuficrj", "yf", "jhpqd", "qnuodq", "ujudcwnz", "bqbeqz", "ifpkhrm", "mau",
					"gbjuu", "iavts", "eazymkr", "cbuspsa", "fpruzn", "wqv", "wydo", "blcvb", "adsj", "ywfhob",
					"ftctdjag", "rwurxzeiy", "mif", "binhqw", "ojf", "zqt", "mbrciwurbi", "yomppjhgn", "shvkstkd",
					"qrpvlj", "tmbtg", "jwwceszrv", "lbsrubv", "nvkzwd", "ipdrsgffju", "cpjxkq", "yetwn", "laqwvlucka",
					"aszyqgar", "xeoktuq", "imwlomhaqx", "egcnawtw", "gkb", "cqyx", "tbzbjjohyu", "yspmfcoke", "xhtl",
					"srorinrara", "cavxvazyzd", "qbbp", "muuwfjq", "hejrqr", "kjy", "mjcxqnwyp", "oamwbpmnfw", "mcvqa",
					"jpwqizx", "mtefec", "ssxsandg", "sfvngozni", "uuwcggi", "bdk", "vle", "kmurbpv", "ox", "quq",
					"jsra", "hevqsmviej", "qtg", "ykc", "tkhzz", "cekttdhzvf", "jllgef", "ehlqvczdwm", "lvkzwd", "ogl",
					"zfazadv", "kwalycxu", "smgk", "ctctdjag", "icvdkm", "vxftpfsdk", "wytwasq", "sastbounn", "xxt",
					"mvhvc", "ncqrkwl", "llckwlh", "yzmzsx", "kbratbsiiq", "osutmimzv", "flrvidejjw", "ypnyl",
					"lkvaffnbh", "sfxn", "rvdgcip", "kfjdexxpub", "hdpl", "eixwjbiec", "mdrbrb", "vl", "gnvopv",
					"gupsq", "ukojvyol", "bgr", "hgoje", "mnm", "pmoqg", "zlbgd", "jbugw", "ksolnoye", "xazofnnnfw",
					"nbratbsiiq", "eedsbwlldf", "oyqp", "icxjnq", "wgodtaqd", "eajtjajx", "nrfrgfrfq", "ruplx", "xp",
					"blm", "wkcnpqwo", "ctcwn", "ovgniuqkz", "yohwwjlw", "amp", "tcqlqrr", "tkxcrwpyn", "yjmbqvqwj",
					"utr", "ypjenklc", "cutbqjbe", "hssq", "axqtgc", "hynaqzsk", "murgikmah", "tfqxylhrkr", "tso",
					"pwjolkqgol", "pxtrlco", "dnpyychl", "fnlgyvp", "uqvtjea", "tehtpck", "xrhz", "eyyeoldy", "oyjgm",
					"ggr", "cyyqoq", "qdkatk", "gdiv", "jgmo", "ddiksfm", "rdalungn", "vuxpnbek", "qskdvgqump",
					"sjynlv", "zbauiaycr", "dfqjbawlsi", "ptg", "jpdgmhoqey", "uhmaatbj", "wwhramf", "nqqiswtrha",
					"alj", "qqhwpjs", "lpsm", "cnbloyfoi", "vjzkk", "jvgxjix", "ojpn", "glnuw", "xgmocim", "nhlumwy",
					"axin", "xaocwbrh", "pphwlffvqh", "xeo", "npvwuqfwrf", "chdaeth", "xdze", "tuovn", "ozvpfar",
					"yaxhy", "hjn", "saqfiy", "sbrmgwbb", "mmhuemhxk", "zgaeinrd", "pgajyj", "yos", "ihnqoj", "bbk",
					"wvvflcn", "yupejuoz", "askdvgqump", "ok", "vhht", "rjgmlvbqyt", "tjlfkw", "dlxj", "pocndzo",
					"ctoi", "oprf", "wxnqbmdc", "netrr", "eeyrbazeb", "ujflvcvbb", "cjrhxcnwd", "fulabbdjhm", "ckwb",
					"ftqiyfpynp", "hfchcualf", "svl", "tbxlw", "avbf", "quqsjnrz", "ikkbmi", "tpqwioig", "tixawj",
					"vyrxdih", "kiqlooa", "xygnyzm", "ybabejzok", "loptagh", "lofhlvf", "bleehdh", "gth", "gufjyz",
					"geirtm", "rtorvbmc", "otczad", "mykpgwaawa", "tulxujxgwa", "ytrjcbf", "zihgc", "hrqkglps", "kxxt",
					"gno", "tx", "awal", "eaktcgh", "beez", "shnrupvsj", "vhizzbc", "oznc", "sju", "lokwh",
					"uwhrqwvvzv", "rllgxo", "noghaxku", "uxhptwholr", "vnzvdqd", "xjmazdmypd", "nimntr", "nsh",
					"vxfnbdtw", "gjxrofmecu", "olkgcp", "yxpzl", "axcueace", "jonihds", "cwboogv", "vcm", "kbjpt",
					"kog", "nyeye", "cgvztdow", "wcyo", "iilencqs", "ewmlklw", "vzfnnuty", "syh", "dgmywgmg", "nizyv",
					"uoa", "odpfxd", "ficusurai", "aintxh", "mmhfowm", "sxebkacee", "upq", "suvqej", "wixyhiwfxt",
					"uvlc", "awxoru", "rhggsyk", "jes", "ucwa", "zewimyyr", "imyxqts", "jcrpzg", "flhpxqghdc",
					"dvlstbkiec", "olkruwibl", "irzuwcnee", "gmdbnlb", "ptfpqnf", "qrrdjwok", "onhmtn", "zcuaetg",
					"zpjffphu", "ql", "rryswt", "maw", "ubic", "pecgnrjewg", "yikoqyumj", "rzjbhbc", "jlivwrbgsf",
					"jzl", "usufincxpf", "uhlvc", "zwevosoji", "sbac", "rwqcccki", "zkyxopeksu", "hbyvgwkwd", "paiiljz",
					"mfucashwut", "pxbxz", "nguzjallie", "gdjvauqksy", "xgobj", "umpjyxcmil", "ajlen", "qlep", "nipka",
					"ztiyipk", "vbuchru", "pww", "kpb", "qtgty", "jniejb", "zqsa", "cbwtopxw", "kemhscud", "ctcdlu",
					"raismk", "ajgsywq", "atpeagd", "mejpij", "qjtrtly", "dtorvbmc", "judlyw", "olikvq", "iyho",
					"zdbtde", "dvb", "kvtbhtyexe", "gvdhv", "yrfqcrdgrz", "sejqw", "eeogvjz", "mnumsmm", "uqigytvso",
					"eexk", "ycnvd", "wsk", "xkiuiam", "fotzhyhgr", "sudrof", "ggqkp", "qbuchru", "kvgrnmh",
					"lbkuxdzdv", "yxdsfalna", "cin", "lty", "btum", "mjzkk", "ivfwujr", "hklxgfamfx", "hrohhdqcny",
					"rcascabb", "fvt", "fctejbf", "rjxxfe", "lcu", "kanstyw", "jporku", "kils", "vno", "svbf", "vgcebx",
					"hubqrdmujv", "cdl", "lyrwzboop", "vazymkr", "kencolhq", "gkky", "gf", "jcgwxtcouz", "eyv",
					"ggeygwhed", "isgyal", "thhrxy", "nyioww", "wlqjtcrwtt", "xobfxvkwd", "twumvxh", "jmyjnh", "pmlk",
					"hssarzysk", "msufincxpf", "jot", "bmmazl", "ojhkqhr", "rzkbpmi", "zlfsaqmb", "bvjqsth", "osqpz",
					"jqlhndn", "qtxwxhcnc", "yeytfzgyy", "iwyqntmspn", "vehpwyx", "qkobp", "tihxrsal", "kptuslikp",
					"iiwz", "vodkxzs", "hxac", "imuzxdltgr", "mtnvmpkp", "ibl", "fjnw", "nxdjf", "bdcjxtrn", "uqndopnk",
					"xgh", "pszpuyiazz", "kmckg", "kqr", "qolip", "zlqelespb", "hjz", "lpfwhsedek", "kvj", "zevrppqr",
					"xaoimyqq", "xzdhmflcj", "faegtssg", "afdktuqfgn", "xugcxihug", "ghghiydrcm", "revsdb", "nqujg",
					"lrkn", "lscmycdvyx", "nhu", "ewlvdclx", "wbpnjauq", "vbgkitp", "sgp", "lysgcpqin", "oqkvkxua",
					"fkm", "fqy", "jaa", "mcwa", "ufxq", "gdfeobyod", "spenbbkkd", "tcmpbxcs", "volip", "gwzzlxlcn",
					"titdobq", "vdjq", "ciopod", "mmiuvbtfqv", "qveobhdaga", "wrjvsk", "darybdec", "ejjm", "ldplhfbin",
					"tv", "ouvmpwyi", "vkjutjguwp", "qkyln", "dvl", "rsvjvvzuly", "jzgxu", "sir", "dnvwwvzppt", "foth",
					"lvjrkeg", "ibshooclo", "xicpnvp", "fxwy", "tivuptayi", "szyuxg", "podqs", "fbk", "bptur",
					"yetttobx", "ufuaaamfbx", "udsicjoic", "qwi", "hildtickey", "vdqdl", "skiwsik", "hiytvkxexs",
					"tkrj", "xni", "ypgqlnsi", "ikzanp", "eqehsikqc", "awpthh", "bawwouccu", "seogsy", "zdoomfqep",
					"kyfhurvko", "ghpkyvbl", "uldri", "oqeuh", "dujq", "mzxoest", "mpi", "fehykdkro", "dtzx", "katno",
					"xigmteppas", "zjyabh", "wbznhxmziw", "cxfvqzexv", "hxk", "mwhqolok", "hbfjkortow", "sjqzknazi",
					"yloamel", "cingxvvr", "nsjnjtjzf", "zxdvonjnk", "cplisr", "xpg", "dfhdrx", "tmv", "vqkqw",
					"jsyltjyjr", "lhsc", "ecexx", "ylcoscjdg", "updspv", "ymbtg", "eppkfwzkol", "yoei", "qbggxelbbo",
					"ummaifmh", "heorvrh", "nvipc", "bluvl", "wteuumdqtv", "jfjq", "krsie", "ngysf", "xyvhdvf",
					"wsidfwhlr", "avsrqqroz", "gzbwf", "zucd", "acepmxorx", "psvu", "vkmiy", "ykit", "ogyyocyc",
					"wuckxggzks", "ubwtopxw", "tyofdvfxf", "gyioww", "dfxjjujwr", "cmsdvj", "urwg", "syaolx",
					"xjmbqvqwj", "bfgvz", "gcdkcy", "ximevcpcu", "yudaxtjf", "yhfpvdlri", "ofaehzbeqz", "xevzhhwye",
					"sibrjbhu", "jas", "ucgtuwdwu", "ceixwz", "wzmzsx", "qxrknsmmjo", "dpmrb", "fcfjetd", "hmikcwh",
					"xcpauje", "mznzbvjf", "rumlsg", "ahg", "ncannzvpv", "abyvbfgpa", "nmpeswpvan", "sbk", "wrqr",
					"qzhxtcfct", "nyddvtevt", "duy", "ugelaxqtk", "mdm", "dknabpkq", "ixac", "xvhsoem", "ytovbripfo",
					"wpbv", "plzcixmx", "fmd", "bgfib", "tidqu", "bpj", "deh", "teopxlwzub", "qjeff", "vuiks",
					"bhtgkqujb", "ksaahbxk", "hykvwt", "lbnyztptaz", "tijakxr", "cqnu", "ivq", "yzvpfar", "siwz",
					"imqncdpwu", "vdf", "blmnutrovy" });
		}
		System.out.println((System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			distinctNames2(new String[] { "qyrsjqf", "npkwrvpw", "sr", "dvvddivf", "swpqw", "gde", "xfthxrdrvr",
					"juxigiv", "dxac", "lrahacr", "bpkfkkim", "lmmcyhmf", "knirgdz", "dhkntz", "gtmctc", "ztm",
					"kgsxfiqk", "iwqxls", "dentvnwpf", "fflfbw", "nyhmwkqy", "nnsr", "kpfjxaa", "fmp", "bp",
					"ilvjonvtx", "nevsdb", "pymgvwxie", "prvhi", "koolvw", "kjxnluc", "fbjby", "aqhyjobtxh", "qxb",
					"axalyokepd", "hbywdxsupd", "kezpeq", "ckahdikh", "cxsqm", "poxfgzdr", "qawwouccu", "nwo", "bzp",
					"chujtykq", "aqcpkaqf", "fgkz", "thvlpru", "fkbkwc", "wekwrujgje", "eigqtdjrj", "lzv", "nkuxhyeqdl",
					"sywbvi", "rwqbiefgy", "jsl", "aygvuwjwc", "ooghaxku", "fnwgp", "msqpdnsnx", "fpspkb", "etsiyudio",
					"gcst", "olfca", "vp", "kyklq", "gxxss", "cnujfvjawf", "toe", "uhjajlx", "ugmne", "ehtv", "crgrjdx",
					"tjyjqkfgrm", "zcmpbxcs", "ovg", "munepcdlgm", "trgrdnay", "qplsni", "lxffjpzvwt", "xnbatnn", "fcm",
					"xhmaatbj", "lgjuqvyxdu", "gcfnhp", "nfcfqwu", "yoxqyzbdz", "urmrlfgu", "nxeg", "uwpqw", "nrnmljlk",
					"joc", "fybem", "nhqw", "grdkrj", "edzyxivptf", "yhrwvh", "rxvjrhzju", "rh", "qeomu", "zulhtc",
					"rgb", "kuomkacx", "yuo", "pbyuaof", "pqcdtnnt", "pmahdqpav", "ybkailmtl", "nptwdmdqc", "tkxy",
					"fmixd", "vwpt", "sodqs", "teuahbuh", "krycwlacvp", "ubdekyqq", "tfwzjac", "sldsnlyz", "waxg",
					"fvezyktac", "dhozhrqo", "qpluqel", "zjsxro", "snzp", "qjql", "fo", "cfwzjac", "axx", "damwbpmnfw",
					"gyemxvmk", "dklrjcta", "wgtakz", "fxamrpksb", "tdnihkqvz", "lqjbvz", "qpwpkgp", "uruk", "gpwl",
					"vdxcwchir", "sybps", "wmsmsnpr", "uvvgpdixci", "otu", "vroand", "klsfvjfmfu", "yma", "lbhywilh",
					"nvuhvfy", "ns", "gcehop", "wbgzfjnp", "nhe", "tyept", "dqy", "lop", "ozonsqu", "bzn", "blxgp",
					"lxyzr", "uuvepvw", "gbzpbqwapt", "nggdoivw", "hvk", "xyv", "dtcjn", "rqf", "epobzvdvt", "nxxss",
					"bawbijga", "kglt", "wnxwjk", "wfvngozni", "byxajgdhq", "oimjinoz", "jzeq", "jcvfjmt", "ozvmmmn",
					"xdydx", "bcpzizufrz", "msfclryn", "zqvh", "dfizi", "ricrfefchc", "prhrtud", "ooho", "eex", "uky",
					"epeoku", "dqqgnx", "fxrt", "rtpn", "ttmsnkvfn", "oraw", "yivuxmr", "quaod", "jvdm", "zggw",
					"fcqknmbg", "saztfv", "xqqgnx", "sevxnkau", "szcpujmukh", "azkusw", "uphaaqz", "lwt", "egczle",
					"oqhwbz", "mtiaukam", "nhvoyijqvr", "spxwic", "lni", "huhlgucd", "fexrf", "ule", "xfopjkbnk",
					"hdtgt", "kersenxw", "rggqwfvjtx", "tzfbfvops", "btqqpvx", "vtax", "qqpljw", "sgjtljxfs",
					"exikwbzdqn", "wqo", "sgtr", "amblqp", "zlnuw", "ehn", "fbcjifximy", "ipmrb", "tcgwxtcouz",
					"zxaudcn", "ggpiyjm", "wqtp", "kphxkhzt", "eawwouccu", "fumpqohi", "uevh", "npgundthg", "uznjpqmaw",
					"jho", "mdofqikf", "burpocyfz", "xxox", "lzeq", "nu", "yguxkuzi", "jnwavpbiqe", "bhdxdaf",
					"lyvilxdt", "oljiyosb", "ltgb", "kxnz", "hpukujk", "gcfboi", "gaktajlyda", "xsvjvvzuly", "flnliopr",
					"stgcl", "uaqcoo", "vf", "qaztfv", "oypfqoa", "ewwfixmkt", "jvpldq", "hsfsjkw", "guvqej", "wcep",
					"xdkztmrsp", "mc", "jexrpmcibv", "qspsxinmda", "qwwkdyugq", "pkrmavvgu", "nyrsjqf", "npq", "udilq",
					"chawer", "ecxqdxz", "hq", "zubltv", "vdtljiitec", "xefchsvu", "eqkn", "oiyd", "rvteyyst", "zo",
					"hwcqzz", "nrvdpcltov", "yoptagh", "slgdontkso", "hpruzn", "rgmywgmg", "gbyf", "iutmkeyco",
					"itfpqnf", "xdvhlojb", "gtobi", "ykhndtp", "gszbw", "eclrd", "qneuh", "oejsrh", "tarvece",
					"bbwuvek", "jiribvugg", "xvlhkidaj", "hqljksfj", "qtka", "xhsxpggbjx", "jbuchru", "di",
					"xvvbuwripj", "gqiqxu", "yysgcpqin", "mzzoxrbff", "dqkqw", "vpu", "jpuyrfhxf", "bf", "iwmr",
					"inmtkyx", "ekucnjeqj", "xzb", "dbwgcb", "uaegtssg", "mnmvfryohx", "ytg", "upaimxold", "qtefec",
					"ugzppq", "kzddqp", "vppkuejvt", "sxjqv", "drefdtze", "mrovxam", "rwlwaz", "knur", "wwyfpzh",
					"vqhjt", "gbrwx", "kkahdikh", "fpjvf", "lerbhb", "bit", "xyjgm", "pyydfqs", "lhqsazkv",
					"lslrfnjiyl", "tuv", "bteuumdqtv", "zgfwe", "qvpagasiz", "xzubqvkh", "fzy", "kxmdez", "ldze",
					"lkjkvs", "nqbnoqqulo", "phtispt", "eyn", "vrblyvktmx", "gvju", "biulxdzovh", "nrdfwh", "qmecq",
					"dpwlbjgx", "yrhqsvm", "scx", "imdcnnew", "hlueo", "ryhmwkqy", "knwsj", "hdnwtmz", "jxxwsdijb",
					"gddh", "mhdggdzcsm", "temhscud", "buoqogkvs", "rbvvph", "xaslicd", "agl", "qagqmzucou", "haoqxyqz",
					"czcpdzq", "zumga", "kwkex", "duvjqcgtin", "liuluppyo", "yublbnogy", "lytmyolobk", "siywcrcbj",
					"sqbvvaf", "iwug", "cdqiuzh", "xek", "uauzb", "zdnihkqvz", "lxv", "ccnr", "argwpcuf", "tyzlzex",
					"ru", "yehzminwwn", "wyr", "uxkzajn", "mejhtqae", "qiilbepkr", "izznvsj", "kvgzo", "abd", "kwupuzp",
					"lipylydc", "lxac", "dcwtfjumg", "glndsssfjc", "odzvwxyubh", "orbdlrriis", "bedrjigyt",
					"oxnttgjlzy", "mjq", "dhzrzcne", "lrapm", "fdlrolzu", "gsa", "akblvoa", "epaksd", "rbssske", "jnv",
					"vhvlpru", "qhah", "oolk", "uilpeztrrq", "aeelfiry", "wivbgemsb", "yoigtqnwqh", "ieypamhcq",
					"tsxke", "edeun", "fkjutjguwp", "evxaec", "ibugw", "ukujj", "klwgh", "ktbyq", "sznlaeer", "nbhfsjt",
					"gvsnx", "qpbdazu", "noebyfv", "loisay", "imgzbkc", "whgfk", "ukhctrhi", "dnv", "uxsmb",
					"ozfzpkwjnl", "dretiqh", "errrbze", "qwd", "vzaeqxbqb", "nuv", "halmb", "igm", "yjsqketzc",
					"icvilrxpos", "kirycsvb", "zsuznof", "xus", "xbuspsa", "fg", "lmyzounckw", "bdvmev", "teafya",
					"zus", "mihdmdfwr", "ciwn", "betdtajmg", "tcolpljf", "dgssqe", "uvrbnf", "pozoenu", "tybc",
					"rhphtc", "lzpxktwkf", "uqctfth", "uiyw", "ubdarctj", "sfitb", "jrygtv", "fttsva", "xrdjnlgi",
					"vtpxnxy", "lgakilcrv", "jilzwpvr", "tcifccmssq", "gtrid", "bujgpbf", "txjn", "wcy", "kqcijvj",
					"krxboecrc", "ayptbrrysu", "preq", "ujvnvro", "wesovpctyg", "ebzxcm", "zgbavjvaa", "gcbca",
					"vvhscl", "lji", "kg", "egsqiv", "fuggcnw", "mdftciw", "vwzn", "cie", "xyept", "kclidoj", "hkieusm",
					"wnih", "akbbgucav", "kep", "whutueson", "vwixzjcpnd", "cu", "kvjrkeg", "umyunzlfiw", "lbf",
					"chpopdi", "bacygumq", "fdkztmrsp", "yzbwf", "mbwfagabon", "oaoimyqq", "dnmtkyx", "yuovn", "cgsqiv",
					"aryjbbs", "hdpwmxc", "gtwocdlcl", "tgt", "fqdfuzwx", "olva", "ucwxwo", "gmprusqod", "eibr",
					"bpbvdud", "wb", "vfqxylhrkr", "mhxzfe", "dnkqfjjqpk", "eqmthwzctm", "gfijudvys", "badtnfswv",
					"raslicd", "vpfem", "mexgwqgqh", "bhtcuhte", "qic", "lgdli", "poqekeafm", "qhtwrxiibu",
					"jvmmxdvylt", "qwtnclzqnr", "zsyjild", "fweyoq", "fp", "uohzkxvf", "czdvb", "exri", "enaeol",
					"onlakowthc", "xja", "gibcvlmmh", "ixafda", "vqhndhd", "txttmhcouq", "drrbzr", "bbgcu",
					"ntmqvvisul", "vzc", "wbmg", "xyirbu", "uzfzpkwjnl", "xnkl", "htkh", "rzzwgq", "lsq", "ph",
					"rueolhy", "ttwnbbheeg", "kqofyyq", "rmkfk", "ebksm", "iqzbqegkd", "kyipjxkxvq", "szvc",
					"hywfvajuy", "olfp", "jkazzyx", "utovm", "tfwzxbrpy", "yg", "bcoiajzt", "jpwjmjgr", "baqtb",
					"dcoiajzt", "imiidi", "jjgfnqnqk", "xevcbv", "evrwjqtdhd", "zfdlh", "auqxvtf", "ylrltfl", "xrwyybr",
					"xpalkxatmz", "ogxrxsphn", "upjvf", "uibov", "rlych", "vulabbdjhm", "vebl", "tiyhxjx", "nycozdxlu",
					"dsa", "qrymazijmp", "mbs", "hejo", "tysljjdjti", "huljn", "lsie", "wtnwnnvr", "itilfthq",
					"hdtilpp", "sdmxpaso", "cudrof", "sydztlc", "zxt", "tjf", "xibck", "btpij", "ucws", "ibku", "tohx",
					"gbyvtr", "zdw", "oysp", "pgqcupx", "eozuc", "jwpyoimvng", "foso", "oefchsvu", "awoo", "rwc",
					"mlolzxdmns", "klgdontkso", "zyjzb", "kkosyio", "exac", "bcfeawureu", "spmrb", "yxyzr",
					"jwogogedqf", "eetbflrpif", "elfdcfsbo", "xchkhqwgh", "hhs", "koe", "lrcsssy", "adljehijd", "tjuz",
					"xehzminwwn", "knqswif", "zhppqzhrfn", "tgdryzpp", "lftrjupjy", "eothz", "pekizk", "ubacrf",
					"ubgcu", "uxkvlezwc", "bhzmlijkii", "hvayzv", "eguteh", "zxrinu", "ciyhxjx", "in", "xvqfjhfry",
					"tdjq", "cppkaef", "ooukycmgc", "qaytva", "zzec", "ttp", "btgeoimmwg", "xzawov", "ykj", "onwgp",
					"wreuw", "yyvhdvf", "czvmavvp", "pfgvz", "xc", "mbddieqgj", "jfayqxxw", "evivvfxr", "vlocqsfxh",
					"sbapflgi", "ivwud", "ucuvle", "pxtm", "rjgsywq", "psdxg", "anl", "lskdvgqump", "orefdtze",
					"oxdrwj", "xuzsskz", "afgfhpfxsx", "niti", "lyisbpw", "wakvqfcr", "nqbtmo", "lrdfwh", "aopoazri",
					"fmimjvh", "varjohqm", "yar", "na", "brmrlfgu", "pgdxefhj", "sprolyhylz", "dyf", "igjf", "nutvn",
					"bsst", "ijtlqgw", "fhjajlx", "cwvak", "hzdve", "fuixtmztvs", "qtpfovago", "npuwabxf", "rbgcu",
					"zuqwfqz", "snpyychl", "wqcdtnnt", "sifmk", "cyorvkzy", "jnkqfjjqpk", "aunlw", "uqvge", "qdsyk",
					"hikhufl", "ckahtfgc", "aitfy", "noza", "cxfnbdtw", "mypddn", "ufyd", "jcf", "jgpovk", "kvv",
					"lpblwiurfv", "fwftxr", "teockxldsc", "ixdfqugxt", "fvg", "tmeec", "giywinxvho", "ovaelaxv",
					"hjdfdgeii", "yqstdrucuk", "otthclky", "vn", "bgpitppo", "mvo", "cltp", "dil", "xnb", "kccpa", "rk",
					"xiondaeish", "elvqwr", "aqbifrhx", "sfqlepxnge", "qbwfewxalz", "topos", "tiajycvqvh", "unlakowthc",
					"djfjq", "oph", "ornr", "itqiafwr", "qreeavecar", "teapuylykf", "vvvcn", "tr", "btmptq", "cfpvh",
					"depevx", "makvqfcr", "epnpqiz", "ahshk", "wryjbbs", "exhrk", "qohqwhiyjs", "unb", "zcp", "cqobnx",
					"iib", "iecbupczks", "gubnyfsywv", "fgpiusmic", "zbir", "jogzk", "hivbgemsb", "yvzht", "btilfthq",
					"jivbgemsb", "zzngvfya", "ijgcpnfvu", "ehpopdi", "feql", "ejhxexthhi", "zypcokdblb", "ilbgd",
					"rjbkrzma", "wvsbilano", "uyewnu", "dcckjdt", "qrkcvis", "kvbbgyov", "koukmpqw", "ndwhpejxyv",
					"iqhwpjs", "ftaomrqe", "mwibxbbb", "ezzrrx", "hjhenzwea", "gxbtnj", "cufftag", "rkwcjcv",
					"rgbenqtja", "hxno", "xocymnskkm", "xcfojdr", "hrhaatvaq", "hgaqq", "cvj", "gfdmadjq", "kew",
					"tlsflkvit", "qgmtopcvf", "hpfskkz", "dxdvantsnt", "xqoy", "nefoy", "lmtcqptp", "eflox", "qgzxbn",
					"ifot", "czpxchqc", "tvkhvjtkn", "rpnbjni", "fdlfbho", "kmarkhdbz", "gxjau", "hmbjhaawtp",
					"sbwhunlmz", "jxqtgc", "bgzfmmhlz", "zgagg", "xppnkuzugk", "kstqfhgzu", "ytkqrie", "uryhskf",
					"qewwpeav", "ugubcuzhx", "twfbqtuqha", "hdf", "eqdm", "nqyp", "rgj", "ngajyj", "ufzxk", "vqoy",
					"zqobnx", "ijhkp", "ypdspv", "gwfzyamz", "geurvenewl", "siyhxjx", "oaq", "ukzanp", "koxo",
					"intrgwip", "lrgotgia", "gidhoqtce", "xtvjx", "cztfdvxf", "hoodipmzou", "bbssykqjx", "xnl", "lkl",
					"hdyierkbf", "gfvk", "pcolpljf", "xslrfnjiyl", "beyzb", "xeeum", "nrfnga", "pttj", "btn",
					"pmfeebdxeg", "atvbsrazai", "kluvlvldz", "wxpzl", "hhogxrklii", "riwn", "btyrfmlvvz", "rsecpdchl",
					"mvjcc", "fsfnjnogwb", "xqry", "gjmu", "pzlesb", "ejyejx", "bzotkr", "wrjlhyccme", "bozhoofxu",
					"ctdrj", "kis", "cikhufl", "hlar", "pry", "zsxke", "agb", "zvrwjqtdhd", "grwt", "dqmflj", "yvizzy",
					"qzipq", "sofhlvf", "waijidrqz", "lwfphjmipv", "kzfzpkwjnl", "jxq", "guuancqhqu", "oqcgm",
					"geoksuqohu", "cdsijcvp", "umnrm", "vkirl", "bhklwyeyta", "mjyuvlwq", "nuubqu", "samhh", "khd",
					"akyuowqb", "zmmiih", "ixayge", "wurgikmah", "tdb", "mjkbuh", "xzvpfar", "tgmq", "cikfvcvkhm",
					"bdbteaxdyc", "xiqqsij", "xqtftp", "tobe", "wkxtatqpsr", "tcsuxuxt", "tpj", "hjkrnf", "nhqwrml",
					"zjmw", "admseaqdii", "id", "emqzz", "jgpiyjm", "qujq", "dz", "owoi", "wxiqt", "hsgbcbwsi",
					"wxbloijch", "gkqtkv", "nppe", "ltux", "mfynwp", "ozqzp", "znbatnn", "usfclryn", "oma", "sknz",
					"xww", "sgoje", "xotjx", "vrpmvarguv", "jeployof", "zvwf", "wzlakkcn", "an", "fso", "qeapofdkr",
					"es", "wvvyzldfe", "rxbijjbflj", "noahkz", "cupgee", "ntarmbl", "dlv", "bzpj", "oaqpwffjv", "fn",
					"nwzkgbxnp", "ejdrh", "vkfwu", "qujcw", "lxbxoktuu", "gqbiry", "blymibrawk", "mjla", "eamhuetv",
					"hrr", "vpmrpvlkk", "txjnyugvv", "ligwxosjn", "mhzfrios", "yxmoa", "gdufon", "lxss", "rtzy",
					"ckbrahsgv", "wrwrlrfdjx", "mqeyxge", "vgs", "eeswapqhd", "rambxfbfa", "bunterqryf", "cphkoqfhi",
					"hvyjtm", "magekeu", "ha", "pwboogv", "cpxofjvsk", "krpom", "nzqw", "oo", "pxhmzbd", "pgr",
					"uttkny", "we", "mwrntwlx", "dyp", "pfiyk", "ysandj", "meqs", "luvlljpgym", "muj", "vjuz",
					"dxdbugvzye", "ga", "kjza", "adkiebv", "wn", "xgehuwshgu", "ctsy", "zwypu", "ruxpxuo", "gmvmquk",
					"eoummzcb", "pydo", "avauh", "drzw", "zldlhiuouh", "hlrchrxtyw", "yv", "qs", "fndpg", "injukdw",
					"cbjktjmo", "wjznw", "yeohuozv", "pcicfcxoo", "bjanq", "jpds", "vqdfuzwx", "uurayjfuy", "imcobjbv",
					"omvisomcg", "siyjm", "yffc", "fkmbzcn", "oixyhiwfxt", "uenmzrz", "jvhx", "tigqtdjrj", "paimepcpb",
					"nppdudu", "czmcyyp", "wtax", "nlibwmrsh", "kvzblbruo", "wazvd", "pex", "wphkz", "dlvqwr",
					"awiffulqg", "jr", "nob", "qhvlpru", "pws", "iycbsvlm", "chqlt", "szcpdzq", "wcymmkmrz", "vrvcqygt",
					"nwcxpjn", "wvbyscdtny", "hnihuyprje", "srzuwcnee", "mldczcp", "bgna", "wwojwy", "btpfovago",
					"apbv", "mppiiozlpl", "izzmhm", "zkjbbcf", "ptegjm", "aqy", "piob", "ihf", "shst", "ugpfsovpk",
					"yemgvlm", "okdrqxvle", "wgp", "wm", "gzlmnb", "uygvuwjwc", "dveu", "ivo", "ahxzfe", "erdmaxl",
					"kmnydezhw", "xugkdfcdz", "oevyi", "jikudf", "dmmtrthkrs", "bbrif", "pjxijpxrb", "sznzbvjf",
					"bstwh", "daangsrk", "woqouco", "cxalyokepd", "yvjvijlq", "twfnwwsxgr", "mglmwhfldv", "utmzqjaw",
					"qpwqizx", "jbmwo", "wqnvbywwf", "zodrjbcr", "iof", "dpwqizx", "raimepcpb", "rebnrhussj",
					"cyflclaeii", "enw", "agjf", "vknabpkq", "ai", "waw", "ugado", "tphxkhzt", "pjid", "yfq", "latb",
					"wgdli", "clatr", "wmahdqpav", "otpgp", "fzz", "hrhrakxk", "xigqieyi", "pvvzh", "bdvhfnmz",
					"fnumsmm", "nvv", "gbekr", "zimjinoz", "zjnmvv", "yfpvh", "ek", "sjfr", "datykl", "hxddnsz",
					"otumwuhd", "nemvcft", "zrb", "bwu", "dywbhvdq", "hrcup", "fefoy", "ukg", "ypq", "vee", "dayyarvi",
					"kxur", "tvilrjjfw", "dabsyzvlao", "qtkqeqw", "vxykjig", "xtlxklc", "bgpyx", "ovjqsth", "gkm",
					"wzhmrnwz", "nhg", "hjqln", "tyzxz", "mkoiolgm", "nnhwzt", "rjaft", "tmlxles", "goyzjywavw", "dbi",
					"eexn", "axsnceluc", "afpahltxr", "bylny", "isoxukq", "ial", "hxhiiruko", "ecko", "ldn", "pwaarhql",
					"epaimxold", "ekviahdmn", "ja", "efqrya", "cnaeh", "tovf", "kdgsvn", "ovnzl", "jrnr", "jatb",
					"yvdm", "gywyfxozyw", "vbhywilh", "rbaujr", "akvvlcf", "ylrwrao", "jeimrt", "elcwqgxky", "oqfngcs",
					"mtyu", "gdsujzj", "ffshjoht", "gzkom", "sfuqq", "itr", "ofrzorx", "utwgxwr", "vptuslikp", "lsdxg",
					"xzcnccrafk", "lwwwuficrj", "yf", "jhpqd", "qnuodq", "ujudcwnz", "bqbeqz", "ifpkhrm", "mau",
					"gbjuu", "iavts", "eazymkr", "cbuspsa", "fpruzn", "wqv", "wydo", "blcvb", "adsj", "ywfhob",
					"ftctdjag", "rwurxzeiy", "mif", "binhqw", "ojf", "zqt", "mbrciwurbi", "yomppjhgn", "shvkstkd",
					"qrpvlj", "tmbtg", "jwwceszrv", "lbsrubv", "nvkzwd", "ipdrsgffju", "cpjxkq", "yetwn", "laqwvlucka",
					"aszyqgar", "xeoktuq", "imwlomhaqx", "egcnawtw", "gkb", "cqyx", "tbzbjjohyu", "yspmfcoke", "xhtl",
					"srorinrara", "cavxvazyzd", "qbbp", "muuwfjq", "hejrqr", "kjy", "mjcxqnwyp", "oamwbpmnfw", "mcvqa",
					"jpwqizx", "mtefec", "ssxsandg", "sfvngozni", "uuwcggi", "bdk", "vle", "kmurbpv", "ox", "quq",
					"jsra", "hevqsmviej", "qtg", "ykc", "tkhzz", "cekttdhzvf", "jllgef", "ehlqvczdwm", "lvkzwd", "ogl",
					"zfazadv", "kwalycxu", "smgk", "ctctdjag", "icvdkm", "vxftpfsdk", "wytwasq", "sastbounn", "xxt",
					"mvhvc", "ncqrkwl", "llckwlh", "yzmzsx", "kbratbsiiq", "osutmimzv", "flrvidejjw", "ypnyl",
					"lkvaffnbh", "sfxn", "rvdgcip", "kfjdexxpub", "hdpl", "eixwjbiec", "mdrbrb", "vl", "gnvopv",
					"gupsq", "ukojvyol", "bgr", "hgoje", "mnm", "pmoqg", "zlbgd", "jbugw", "ksolnoye", "xazofnnnfw",
					"nbratbsiiq", "eedsbwlldf", "oyqp", "icxjnq", "wgodtaqd", "eajtjajx", "nrfrgfrfq", "ruplx", "xp",
					"blm", "wkcnpqwo", "ctcwn", "ovgniuqkz", "yohwwjlw", "amp", "tcqlqrr", "tkxcrwpyn", "yjmbqvqwj",
					"utr", "ypjenklc", "cutbqjbe", "hssq", "axqtgc", "hynaqzsk", "murgikmah", "tfqxylhrkr", "tso",
					"pwjolkqgol", "pxtrlco", "dnpyychl", "fnlgyvp", "uqvtjea", "tehtpck", "xrhz", "eyyeoldy", "oyjgm",
					"ggr", "cyyqoq", "qdkatk", "gdiv", "jgmo", "ddiksfm", "rdalungn", "vuxpnbek", "qskdvgqump",
					"sjynlv", "zbauiaycr", "dfqjbawlsi", "ptg", "jpdgmhoqey", "uhmaatbj", "wwhramf", "nqqiswtrha",
					"alj", "qqhwpjs", "lpsm", "cnbloyfoi", "vjzkk", "jvgxjix", "ojpn", "glnuw", "xgmocim", "nhlumwy",
					"axin", "xaocwbrh", "pphwlffvqh", "xeo", "npvwuqfwrf", "chdaeth", "xdze", "tuovn", "ozvpfar",
					"yaxhy", "hjn", "saqfiy", "sbrmgwbb", "mmhuemhxk", "zgaeinrd", "pgajyj", "yos", "ihnqoj", "bbk",
					"wvvflcn", "yupejuoz", "askdvgqump", "ok", "vhht", "rjgmlvbqyt", "tjlfkw", "dlxj", "pocndzo",
					"ctoi", "oprf", "wxnqbmdc", "netrr", "eeyrbazeb", "ujflvcvbb", "cjrhxcnwd", "fulabbdjhm", "ckwb",
					"ftqiyfpynp", "hfchcualf", "svl", "tbxlw", "avbf", "quqsjnrz", "ikkbmi", "tpqwioig", "tixawj",
					"vyrxdih", "kiqlooa", "xygnyzm", "ybabejzok", "loptagh", "lofhlvf", "bleehdh", "gth", "gufjyz",
					"geirtm", "rtorvbmc", "otczad", "mykpgwaawa", "tulxujxgwa", "ytrjcbf", "zihgc", "hrqkglps", "kxxt",
					"gno", "tx", "awal", "eaktcgh", "beez", "shnrupvsj", "vhizzbc", "oznc", "sju", "lokwh",
					"uwhrqwvvzv", "rllgxo", "noghaxku", "uxhptwholr", "vnzvdqd", "xjmazdmypd", "nimntr", "nsh",
					"vxfnbdtw", "gjxrofmecu", "olkgcp", "yxpzl", "axcueace", "jonihds", "cwboogv", "vcm", "kbjpt",
					"kog", "nyeye", "cgvztdow", "wcyo", "iilencqs", "ewmlklw", "vzfnnuty", "syh", "dgmywgmg", "nizyv",
					"uoa", "odpfxd", "ficusurai", "aintxh", "mmhfowm", "sxebkacee", "upq", "suvqej", "wixyhiwfxt",
					"uvlc", "awxoru", "rhggsyk", "jes", "ucwa", "zewimyyr", "imyxqts", "jcrpzg", "flhpxqghdc",
					"dvlstbkiec", "olkruwibl", "irzuwcnee", "gmdbnlb", "ptfpqnf", "qrrdjwok", "onhmtn", "zcuaetg",
					"zpjffphu", "ql", "rryswt", "maw", "ubic", "pecgnrjewg", "yikoqyumj", "rzjbhbc", "jlivwrbgsf",
					"jzl", "usufincxpf", "uhlvc", "zwevosoji", "sbac", "rwqcccki", "zkyxopeksu", "hbyvgwkwd", "paiiljz",
					"mfucashwut", "pxbxz", "nguzjallie", "gdjvauqksy", "xgobj", "umpjyxcmil", "ajlen", "qlep", "nipka",
					"ztiyipk", "vbuchru", "pww", "kpb", "qtgty", "jniejb", "zqsa", "cbwtopxw", "kemhscud", "ctcdlu",
					"raismk", "ajgsywq", "atpeagd", "mejpij", "qjtrtly", "dtorvbmc", "judlyw", "olikvq", "iyho",
					"zdbtde", "dvb", "kvtbhtyexe", "gvdhv", "yrfqcrdgrz", "sejqw", "eeogvjz", "mnumsmm", "uqigytvso",
					"eexk", "ycnvd", "wsk", "xkiuiam", "fotzhyhgr", "sudrof", "ggqkp", "qbuchru", "kvgrnmh",
					"lbkuxdzdv", "yxdsfalna", "cin", "lty", "btum", "mjzkk", "ivfwujr", "hklxgfamfx", "hrohhdqcny",
					"rcascabb", "fvt", "fctejbf", "rjxxfe", "lcu", "kanstyw", "jporku", "kils", "vno", "svbf", "vgcebx",
					"hubqrdmujv", "cdl", "lyrwzboop", "vazymkr", "kencolhq", "gkky", "gf", "jcgwxtcouz", "eyv",
					"ggeygwhed", "isgyal", "thhrxy", "nyioww", "wlqjtcrwtt", "xobfxvkwd", "twumvxh", "jmyjnh", "pmlk",
					"hssarzysk", "msufincxpf", "jot", "bmmazl", "ojhkqhr", "rzkbpmi", "zlfsaqmb", "bvjqsth", "osqpz",
					"jqlhndn", "qtxwxhcnc", "yeytfzgyy", "iwyqntmspn", "vehpwyx", "qkobp", "tihxrsal", "kptuslikp",
					"iiwz", "vodkxzs", "hxac", "imuzxdltgr", "mtnvmpkp", "ibl", "fjnw", "nxdjf", "bdcjxtrn", "uqndopnk",
					"xgh", "pszpuyiazz", "kmckg", "kqr", "qolip", "zlqelespb", "hjz", "lpfwhsedek", "kvj", "zevrppqr",
					"xaoimyqq", "xzdhmflcj", "faegtssg", "afdktuqfgn", "xugcxihug", "ghghiydrcm", "revsdb", "nqujg",
					"lrkn", "lscmycdvyx", "nhu", "ewlvdclx", "wbpnjauq", "vbgkitp", "sgp", "lysgcpqin", "oqkvkxua",
					"fkm", "fqy", "jaa", "mcwa", "ufxq", "gdfeobyod", "spenbbkkd", "tcmpbxcs", "volip", "gwzzlxlcn",
					"titdobq", "vdjq", "ciopod", "mmiuvbtfqv", "qveobhdaga", "wrjvsk", "darybdec", "ejjm", "ldplhfbin",
					"tv", "ouvmpwyi", "vkjutjguwp", "qkyln", "dvl", "rsvjvvzuly", "jzgxu", "sir", "dnvwwvzppt", "foth",
					"lvjrkeg", "ibshooclo", "xicpnvp", "fxwy", "tivuptayi", "szyuxg", "podqs", "fbk", "bptur",
					"yetttobx", "ufuaaamfbx", "udsicjoic", "qwi", "hildtickey", "vdqdl", "skiwsik", "hiytvkxexs",
					"tkrj", "xni", "ypgqlnsi", "ikzanp", "eqehsikqc", "awpthh", "bawwouccu", "seogsy", "zdoomfqep",
					"kyfhurvko", "ghpkyvbl", "uldri", "oqeuh", "dujq", "mzxoest", "mpi", "fehykdkro", "dtzx", "katno",
					"xigmteppas", "zjyabh", "wbznhxmziw", "cxfvqzexv", "hxk", "mwhqolok", "hbfjkortow", "sjqzknazi",
					"yloamel", "cingxvvr", "nsjnjtjzf", "zxdvonjnk", "cplisr", "xpg", "dfhdrx", "tmv", "vqkqw",
					"jsyltjyjr", "lhsc", "ecexx", "ylcoscjdg", "updspv", "ymbtg", "eppkfwzkol", "yoei", "qbggxelbbo",
					"ummaifmh", "heorvrh", "nvipc", "bluvl", "wteuumdqtv", "jfjq", "krsie", "ngysf", "xyvhdvf",
					"wsidfwhlr", "avsrqqroz", "gzbwf", "zucd", "acepmxorx", "psvu", "vkmiy", "ykit", "ogyyocyc",
					"wuckxggzks", "ubwtopxw", "tyofdvfxf", "gyioww", "dfxjjujwr", "cmsdvj", "urwg", "syaolx",
					"xjmbqvqwj", "bfgvz", "gcdkcy", "ximevcpcu", "yudaxtjf", "yhfpvdlri", "ofaehzbeqz", "xevzhhwye",
					"sibrjbhu", "jas", "ucgtuwdwu", "ceixwz", "wzmzsx", "qxrknsmmjo", "dpmrb", "fcfjetd", "hmikcwh",
					"xcpauje", "mznzbvjf", "rumlsg", "ahg", "ncannzvpv", "abyvbfgpa", "nmpeswpvan", "sbk", "wrqr",
					"qzhxtcfct", "nyddvtevt", "duy", "ugelaxqtk", "mdm", "dknabpkq", "ixac", "xvhsoem", "ytovbripfo",
					"wpbv", "plzcixmx", "fmd", "bgfib", "tidqu", "bpj", "deh", "teopxlwzub", "qjeff", "vuiks",
					"bhtgkqujb", "ksaahbxk", "hykvwt", "lbnyztptaz", "tijakxr", "cqnu", "ivq", "yzvpfar", "siwz",
					"imqncdpwu", "vdf", "blmnutrovy" });
		}
		System.out.println((System.currentTimeMillis() - start));
	}

	public static long distinctNames2(String[] ideas) {
		int n = ideas.length;
		HashSet<String> hs = new HashSet<>();
		for (String s : ideas)
			hs.add(s);
		int[][] poss = new int[n][26];
		for (int i = 0; i < n; ++i) {
			for (char j = 'a'; j <= 'z'; ++j) {
				String s = j + ideas[i].substring(1);
				if (!hs.contains(s))
					poss[i][j - 'a']++;
			}
		}
		int[][] cts = new int[26][26];
		for (int i = 0; i < n; ++i) {
			int a = ideas[i].charAt(0) - 'a';
			for (int b = 0; b < 26; ++b) {
				cts[a][b] += poss[i][b];
			}
		}
		long ans = 0;
		for (int i = 0; i < n; ++i) {
			int a = ideas[i].charAt(0) - 'a';
			for (int b = 0; b < 26; ++b) {
				ans += poss[i][b] * cts[b][a];
			}
		}
		return ans;
	}

	public static long distinctNames(String[] ideas) {
		// Validate input
		if (ideas == null || ideas.length <= 0) {
			return 0L;
		}

		long res = 0L;

		Set<String> list = new HashSet<>();

		Map<String, List<String>> map = new HashMap<>();
		for (String str : ideas) {
			String key = "" + str.charAt(0);
			map.putIfAbsent(key, new ArrayList<String>());
			List<String> bag = map.get(key);
			bag.add(str);
			list.add(str);
		}

		String[] keys = map.keySet().toArray(new String[0]);
		for (int i = 1; i < keys.length; i++) {
			List<String> bag1 = map.get(keys[i - 1]);
			for (int j = i; j < keys.length; j++) {
				List<String> bag2 = map.get(keys[j]);
				for (int k = 0; k < bag1.size(); k++) {
					for (int z = 0; z < bag2.size(); z++) {
						String s1 = bag1.get(k);
						String s2 = bag2.get(z);
						String s1U = "" + s2.charAt(0) + s1.substring(1);
						String s2U = "" + s1.charAt(0) + s2.substring(1);

						if (!list.contains(s1U) && !list.contains(s2U)) {
							res++;
						}
					}
				}
			}
		}
		/*
		 * for (Map.Entry<String, List<String>>entry : map.entrySet()) { String key =
		 * entry.getKey(); List val = entry.getValue();
		 * 
		 * }
		 * 
		 * for (int i = 1; i < ideas.length; i++) { for (int j = i; j < ideas.length;
		 * j++) { String s1 = ideas[i - 1]; String s2 = ideas[j]; String s1U = "" +
		 * s2.charAt(0) + s1.substring(1); String s2U = "" + s1.charAt(0) +
		 * s2.substring(1);
		 * 
		 * if(!list.contains(s1U) && !list.contains(s2U)) { res++; } } }
		 */
		return res * 2;
	}
}
