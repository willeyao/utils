package com.shuwei.elbs.util.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 跟时间日期有关的静态方法类
 *
 */
public final class DateTimeUtils {
    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final long MILLISECONDS_PER_MINUTE = 60 * 1000;
    /**
     * 得到 yyyy-MM-dd HH:mm:ss 形式的日期字符串
     *
     * @param date
     * @return
     */
    public static String getFullDateString(Date date) {
        Objects.requireNonNull(date, "date can't be null");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 字符串转变为date格式
     *
     * @param dateString
     * @return
     */
    public static Date getDateyyyyMMddHHmm(String dateString) throws Exception {
        Objects.requireNonNull(dateString, "dateString can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//小写的mm表示的是分钟
        return sdf.parse(dateString);
    }

    public static Long getTimestamp(String dateString,String pattern) throws ParseException {
        Objects.requireNonNull(dateString, "dateString can't be null");
        Objects.requireNonNull(pattern, "pattern can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateString).getTime();
    }

    /**
     * 字符串转变为时间戳毫秒数
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Long getTimestamp(String dateString) throws ParseException {
        Objects.requireNonNull(dateString, "dateString can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.parse(dateString).getTime();
    }

    /**
     * 时间戳毫秒数转变为字符串
     * @param timestamp
     * @return
     */
    public static String getStringyyyyMMddHHmm(Long timestamp) {
        Objects.requireNonNull(timestamp, "timestamp can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date(timestamp));
    }

    /**
     * 时间转字符串
     * @param date
     * @return
     */
    public static String getStringyyyyMMddHHmm(Date date) {
        Objects.requireNonNull(date, "date can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

    /**
     * 获取 06/20 的格式
     * @param timestamp
     * @return
     */
    public static String getStringDateMMdd(Long timestamp) {
        Objects.requireNonNull(timestamp, "timestamp can't be null");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        return sdf.format(new Date(timestamp));
    }

    /**
     * 获取 06/20 的格式
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static String getStringDateMMdd(String dateString) throws ParseException{
        Objects.requireNonNull(dateString, "dateString can't be null");
        long timestamp = getTimestamp(dateString, "yyyy-MM-dd HH:mm");
        return getStringDateMMdd(timestamp);
    }

    /**
     * 得到两时间之间的间隔天数
     *
     * @param after
     * @param before
     * @return
     */
    public static Long getDatesIntervalDays(Date after, Date before) {
        Objects.requireNonNull(after, "after can't be null");
        Objects.requireNonNull(before, "before can't be null");
        return (after.getTime() - before.getTime()) / (MILLISECONDS_PER_DAY);
    }

    public static Long getDatesIntervalDays(Long after, Long before) {
        Objects.requireNonNull(after, "after can't be null");
        Objects.requireNonNull(before, "before can't be null");
        return (after - before) / (MILLISECONDS_PER_DAY);
    }

    /**
     * 得到两时间之间的间隔分钟数
     *
     * @param after
     * @param before
     * @return
     */
    public static Long getDatesIntervalMinutes(Date after, Date before) {
        Objects.requireNonNull(after, "after can't be null");
        Objects.requireNonNull(before, "before can't be null");
        return (after.getTime() - before.getTime()) / (MILLISECONDS_PER_MINUTE);
    }

    /**
     * 获得当前日期 yyyyMMdd
     * @return
     */
    public static String getNowDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }

    /**
     * 获得时间戳对应的日期
     * @param timestamp
     * @return
     */
    public static String getTimeDay(Long timestamp){
        Objects.requireNonNull(timestamp, "timestamp can't be null");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date(timestamp));
    }

    /**
     * 获取几天前的时间
     *
     * @param timestamp
     * @return
     */
    public static String getBeforeTimeDay(long timestamp, int day) {
        long changedTimeStamp = timestamp - (day * MILLISECONDS_PER_DAY);
        return getTimeDay(changedTimeStamp);
    }

    /**
     * 获得时间戳对应的日期，返回指定格式
     * @param timeStamp
     * @return
     */
    public static String getTimeDay(long timeStamp,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date(timeStamp));
    }

    /**
     * 获取今天开始时间戳
     * @return
     * @throws ParseException
     */
    public static Long getTodayStart() throws ParseException {
        return getTimestamp(getTimeDay(new Date().getTime()),"yyyyMMdd");
    }

    /**
     * 获得连续的日期范围
     * @param dayFrom
     * @param dayTo
     * @return
     * @throws ParseException
     */
    public static List<String> getDayRange(String dayFrom, String dayTo) throws ParseException {
        if(dayFrom == null || "".equals(dayFrom.trim()) || dayTo == null || "".equals(dayTo.trim())){
            return new ArrayList<>();
        }
        String pattern = "yyyy-MM-dd";
        Calendar start =Calendar.getInstance();
        start.setTimeInMillis(getTimestamp(dayFrom,pattern));
        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(getTimestamp(dayTo,pattern));

        List<String> retList = new ArrayList<>();
        while (start.before(end) || start.equals(end)){
            retList.add(getTimeDay(start.getTimeInMillis(),pattern));
            start.add(Calendar.DAY_OF_YEAR,1);
        }
        return retList;
    }

    public static Date getFirstTimeOfDate(Date date) {
        Objects.requireNonNull(date, "date can't be null");
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        return c.getTime();
    }

    public static Date getLastTimeOfDate(Date date) {
        Objects.requireNonNull(date, "date can't be null");
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前时间前minute的时间戳
     *
     * @param minute
     * @return
     */
    public static long getLastTimeStampInMin(long timestamp, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.add(Calendar.MINUTE, -minute);
        long time = calendar.getTime().getTime();
        return time;
    }

    /**
     * 获取当前时间前minute的时间字符串
     * @param minute
     * @return
     */
    public static String getLastTimeStringInMinute(long timestamp, int minute) {
        return getStringyyyyMMddHHmm(getLastTimeStampInMin(timestamp, minute));
    }

    /**
     * 将1小时内按每{min}分组，获取前一个最近的时间点
     * 如min为5， 则2019-06-20 15:08将得到2019-06-20 15:05
     * @param lTime
     * @param min  分钟单位
     * @return
     */
    public static long getPreGranularityTime(long lTime, int min) {
        long retLong = 0;
        Calendar cal = Calendar.getInstance();
        if (lTime <= 0 || min <= 0) {
            return cal.getTimeInMillis();
        }

        int rawOffset = cal.getTimeZone().getRawOffset();
        long totalMs = min * MILLISECONDS_PER_MINUTE;
        retLong = ((lTime + rawOffset) / totalMs + 1) * totalMs - totalMs;
        return retLong - (long)rawOffset;

    }

    /**
     * 日期加减
     * @param date
     * @param day
     * @return
     */
    public static Date addByDay(Date date, int day) {
        Objects.requireNonNull(date, "date can't be null");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
        return calendar.getTime();
    }

    /**
     * 校验日期格式
     * @param dateStr
     * @return
     */
    public static Boolean checkDate(String dateStr){
        if (dateStr == null){
            return false;
        }
        return dateStr.matches("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$");
    }

    public static void main(String[] args) {
        System.out.println( 1 << Calendar.HOUR_OF_DAY);
    }

}
