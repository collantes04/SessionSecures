package passwordutils.datasources;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Dictionary to use in PassPhrased passwords
 * @author Jose A. Sánchez
 * @version 1.0
 */
public enum Dictionary {
    SOL(0, "sol"), LUNA(1, "luna"), ESTRELLA(2, "estrella"), NUBE(3, "nube"), LLUVIA(4, "lluvia"),
    NIEVE(5, "nieve"), VIENTO(6, "viento"), TRUENO(7, "trueno"), RAYO(8, "rayo"), MAR(9, "mar"),
    RIO(10, "rio"), LAGO(11, "lago"), MONTANA(12, "montana"), VALLE(13, "valle"), BOSQUE(14, "bosque"),
    DESIERTO(15, "desierto"), ISLA(16, "isla"), VOLCAN(17, "volcan"), PIEDRA(18, "piedra"), ARENA(19, "arena"),
    
    PERRO(20, "perro"), GATO(21, "gato"), CABALLO(22, "caballo"), VACA(23, "vaca"), OVEJA(24, "oveja"),
    LEON(25, "leon"), TIGRE(26, "tigre"), ELEFANTE(27, "elefante"), JIRAFA(28, "jirafa"), MONO(29, "mono"),
    PAJARO(30, "pajaro"), PEZ(31, "pez"), TIBURON(32, "tiburon"), AGUILA(33, "aguila"), BUHO(34, "buho"),
    SERPIENTE(35, "serpiente"), RANA(36, "rana"), ABEJA(37, "abeja"), ARANA(38, "arana"), RATON(39, "raton"),

    CASA(40, "casa"), PUERTA(41, "puerta"), VENTANA(42, "ventana"), MESA(43, "mesa"), SILLA(44, "silla"),
    CAMA(45, "cama"), RELOJ(46, "reloj"), ESPEJO(47, "espejo"), LAMPARA(48, "lampara"), CUADRO(49, "cuadro"),
    LIBRO(50, "libro"), PAPEL(51, "papel"), PLUMA(52, "pluma"), LLAVE(53, "llave"), BOLSA(54, "bolsa"),
    RADIO(55, "radio"), COCHE(56, "coche"), BICI(57, "bici"), AVION(58, "avion"), BARCO(59, "barco"),

    MANZANA(60, "manzana"), PERA(61, "pera"), PLATANO(62, "platano"), UVA(63, "uva"), NARANJA(64, "naranja"),
    LIMON(65, "limon"), FRESA(66, "fresa"), PAN(67, "pan"), QUESO(68, "queso"), LECHE(69, "leche"),
    ARROZ(70, "arroz"), PASTA(71, "pasta"), CARNE(72, "carne"), POLLO(73, "pollo"), HUEVO(74, "huevo"),
    TOMATE(75, "tomate"), PAPA(76, "papa"), CEBOLLA(77, "cebolla"), AJO(78, "ajo"), NUEZ(79, "nuez"),

    SUN(80, "sun"), MOON(81, "moon"), STAR(82, "star"), CLOUD(83, "cloud"), RAIN(84, "rain"),
    SNOW(85, "snow"), WIND(86, "wind"), THUNDER(87, "thunder"), STORM(88, "storm"), SEA(89, "sea"),
    RIVER(90, "river"), LAKE(91, "lake"), MOUNTAIN(92, "mountain"), VALLEY(93, "valley"), FOREST(94, "forest"),
    DESERT_EN(95, "desert"), ISLAND_EN(96, "island"), VOLCANO(97, "volcano"), ROCK(98, "rock"), SAND(99, "sand"),

    DOG(100, "dog"), CAT(101, "cat"), HORSE(102, "horse"), COW(103, "cow"), SHEEP(104, "sheep"),
    LION(105, "lion"), TIGER(106, "tiger"), ELEPHANT_EN(107, "elephant"), GIRAFFE(108, "giraffe"), MONKEY(109, "monkey"),
    BIRD(110, "bird"), FISH(111, "fish"), SHARK(112, "shark"), EAGLE(113, "eagle"), OWL(114, "owl"),
    SNAKE(115, "snake"), FROG(116, "frog"), BEE(117, "bee"), SPIDER(118, "spider"), MOUSE_EN(119, "mouse"),

    HOUSE(120, "house"), DOOR(121, "door"), WINDOW(122, "window"), TABLE(123, "table"), CHAIR(124, "chair"),
    BED(125, "bed"), CLOCK(126, "clock"), MIRROR(127, "mirror"), LAMP_EN(128, "lamp"), PICTURE(129, "picture"),
    BOOK(130, "book"), PAPER_EN(131, "paper"), PEN(132, "pen"), KEY(133, "key"), BAG(134, "bag"),
    RADIO_EN(135, "radio"), CAR_EN(136, "car"), BIKE(137, "bike"), PLANE(138, "plane"), SHIP(139, "ship"),

    APPLE(140, "apple"), PEAR_EN(141, "pear"), BANANA(142, "banana"), GRAPE(143, "grape"), ORANGE(144, "orange"),
    LEMON_EN(145, "lemon"), STRAWBERRY(146, "strawberry"), BREAD(147, "bread"), CHEESE(148, "cheese"), MILK(149, "milk"),
    RICE(150, "rice"), PASTA_EN(151, "pasta"), MEAT(152, "meat"), CHICKEN(153, "chicken"), EGG(154, "egg"),
    TOMATO(155, "tomato"), POTATO(156, "potato"), ONION(157, "onion"), GARLIC(158, "garlic"), NUT(159, "nut"),

    JAVA(160, "java"), CODE(161, "code"), DATA(162, "data"), PIXEL(163, "pixel"), LOG(164, "log"),
    BYTE(165, "byte"), BIT(166, "bit"), CHIP(167, "chip"), WEB(168, "web"), LINK(169, "link"),
    NETWORK(170, "network"), SERVER(171, "server"), RAM(172, "ram"), DISK(173, "disk"), SCREEN(174, "screen"),
    HARDWARE(175, "hardware"), KEYBOARD(176, "keyboard"), ROBOT(177, "robot"), CYBER(178, "cyber"), CRYPTO(179, "crypto"),

    RED(180, "red"), BLUE(181, "blue"), GREEN(182, "green"), YELLOW(183, "yellow"), BLACK(184, "black"),
    WHITE(185, "white"), ROJO(186, "rojo"), AZUL_ES(187, "azul"), VERDE(188, "verde"), AMARILLO(189, "amarillo"),
    NEGRO(190, "negro"), BLANCO(191, "blanco"), FAST(192, "fast"), SLOW(193, "slow"), BIG(194, "big"),
    SMALL(195, "small"), RAPIDO(196, "rapido"), LENTO(197, "lento"), GRANDE(198, "grande"), PEQUENO(199, "pequeno"),

    RUN(200, "run"), JUMP(201, "jump"), SLEEP(202, "sleep"), CORRER(203, "correr"), SALTAR(204, "saltar"),
    DORMIR(205, "dormir"), FLY(206, "fly"), VOLAR(207, "volar"), SWIM(208, "swim"), NADAR(209, "nadar"),
    WALK(210, "walk"), CAMINAR(211, "caminar"), EAT(212, "eat"), COMER(213, "comer"), DRINK(214, "beber"),
    DANCE(215, "dance"), BAILAR(216, "bailar"), SING(217, "cantar"), SMILE(218, "smile"), SONREIR(219, "sonreir"),

    GALAXY(220, "galaxy"), PLANET(221, "planet"), SPACE(222, "space"), ATOM(223, "atom"), ENERGY(224, "energy"),
    MAGIC(225, "magic"), GHOST(226, "ghost"), DRAGON(227, "dragon"), HERO(228, "hero"), VILLAIN(229, "villain"),
    FIRE(230, "fire"), WATER(231, "water"), EARTH(232, "earth"), AIR(233, "air"), IRON(234, "iron"),
    GOLD(235, "gold"), SILVER(236, "silver"), METAL(237, "metal"), PLASTIC(238, "plastic"), GLASS(239, "glass");

    private static final Random RAND = new SecureRandom();
    private final int key;
    private final String word;

    private Dictionary(int key, String word) {
        this.key = key;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    /**
     * Return a random word from the dictionary
     */
    public static String getRandomWord() {
        Dictionary[] values = Dictionary.values();
        return values[RAND.nextInt(values.length)].getWord();
    }
}
