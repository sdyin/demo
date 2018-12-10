package com.sdyin.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * @author: liuye
 * @Date: 2018/12/10 13:40
 * @Description
 */
public class DateUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
  public static final String YYYY_MM_DD = "yyyy-MM-dd";
  public static final String YYYYMMDD = "yyyyMMdd";
  public static final String YYMMDDHHMMSS = "yyMMddHHmmss";
  public static final String YYMMDDHHMMSSS = "yyMMddHHmmSSS";
  public static final String YYYYMM = "yyyyMM";
  public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
  public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
  public static final String YYYY_MM_DDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss:SSS";
  public static final String YYYY_MM_DDHHMMSSSSS_ = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String MM_DD = "MM月dd日";
  public static final String YYYY_MM_DDHHMMSS = "yyyy/MM/dd HH:mm:ss";
  public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
  public static final String YYMMDDHHMMSSSSS = "yyMMddHHmmssSSS";
  public static final String YYMMDDHHMM = "yyMMddHHmm";
  public static final String MM_DD_HH_MM = "MM/dd HH:mm";
  public static final String YYYY_MM_DDHHMM = "yyyy年MM月dd日 HH:mm";
  public static final String YYMMDDSSSSS = "yyMMddsssss";
  public static final String HH = "HH";
  public static final String YYYYXMMXDDX24HHSSS = "yyyy/MM/dd HH:mm:ss.SSS";
  public static final String YYXMMXDDXMM = "yyyy/MM/dd HH:mm";
  public static final String YYYYMMDDHH24 = "YYYY-MM-DD HH24";
  public static final String YYYYMMDDHH24MI = "YYYY-MM-DD HH24:MI";
  public static final String YYYYMMDDHH24MISS = "YYYY-MM-DD HH24:MI:SS";
  public static final String HH24MISS = "HH24:MI:SS";
  public static final String HH24MI = "HH24:MI";
  public static final String MISS = "MI:SS";
  private static final String[] WEEKS_CN = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

  public DateUtils() {
  }

  public static String getCurrentDate(String format) {
    if (StringUtils.isEmpty(format)) {
      return getCurrentDate();
    } else {
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      String date = sdf.format(cal.getTime());
      return date;
    }
  }

  public static String getCurrentDate() {
    return getCurrentDate("yyyy-MM-dd");
  }

  public static String convertDateToString(Date date, String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }

  public static Date convertDateByFormat(Date date, String format) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      String conStr = sdf.format(date);
      return sdf.parse(conStr);
    } catch (Exception var4) {
      LOGGER.error("错误的日期转换", var4);
      return date;
    }
  }

  public static String getNextDay(String curDay, String dateFormat) {
    return getNextDay((String)curDay, dateFormat, 1);
  }

  public static String getNextDay(String curDay, String dateFormat, int num) {
    SimpleDateFormat sdf = null;
    Date date = null;
    String dateStr = null;
    sdf = new SimpleDateFormat(dateFormat);
    sdf.setLenient(false);

    try {
      date = sdf.parse(curDay);
      date = getNextDay(date, num);
      dateStr = sdf.format(date);
      return dateStr;
    } catch (ParseException var7) {
      LOGGER.error("错误的日期格式！", var7);
      return curDay;
    }
  }

  public static Date getNextDay(Date curDate) {
    return getNextDay(curDate, 1);
  }

  public static Date getNextDay(Date curDate, int num) {
    Date date = null;
    Calendar cal = null;

    try {
      cal = Calendar.getInstance();
      cal.setTime(curDate);
      cal.add(5, num);
      date = cal.getTime();
    } catch (Exception var5) {
      LOGGER.error("错误的日期计算", var5);
    }

    return date;
  }

  public static String getNextDay(Date curDate, String dateFormat) {
    try {
      Date nextDate = getNextDay(curDate);
      return convertDateToString(nextDate, dateFormat);
    } catch (Exception var3) {
      LOGGER.error("错误的日期格式！", var3);
      return null;
    }
  }

  public static String getNextDay(Date curDate, String dateFormat, int num) {
    Date date = null;
    String dateStr = null;

    try {
      date = getNextDay(curDate, num);
      dateStr = convertDateToString(date, dateFormat);
    } catch (Exception var6) {
      LOGGER.error("错误的日期格式！", var6);
    }

    return dateStr;
  }

  public static String getPreDay(String curDate, String dateFormat) {
    return getPreDay((String)curDate, dateFormat, 1);
  }

  public static String getPreDay(String curDate, String dateFormat, int num) {
    Date date = null;
    String dateStr = null;

    try {
      date = convertStringToDate(curDate, dateFormat);
      date = getPreDay(date, num);
      dateStr = date2String(date, dateFormat);
    } catch (Exception var6) {
      LOGGER.error("错误的日期计算！", var6);
    }

    return dateStr;
  }

  public static String getPreDay(Date curDate, String dateFormat) {
    return getPreDay((Date)curDate, dateFormat, 1);
  }

  public static String getPreDay(Date curDate, String dateFormat, int num) {
    Date date = null;
    String dateStr = null;

    try {
      date = getPreDay(curDate, num);
      dateStr = convertDateToString(date, dateFormat);
    } catch (Exception var6) {
      LOGGER.error("错误的日期格式！", var6);
    }

    return dateStr;
  }

  public static Date getPreDay(Date curDate) {
    return getPreDay(curDate, 1);
  }

  public static Date getPreDay(Date curDate, int num) {
    Date date = null;
    Calendar cal = null;

    try {
      cal = Calendar.getInstance();
      cal.setTime(curDate);
      cal.add(5, -num);
      date = cal.getTime();
    } catch (Exception var5) {
      LOGGER.error("错误的日期计算", var5);
    }

    return date;
  }

  public static String date2String(Date date, String format) {
    if (null != date && !StringUtils.isEmpty(format)) {
      SimpleDateFormat df = new SimpleDateFormat(format);
      df.setLenient(false);
      String time = df.format(date);
      return time;
    } else {
      return null;
    }
  }

  public static long getDaySub(Date beginDate, Date endDate) {
    long hour = getHourSub(beginDate, endDate);
    return (long)Math.round((float)(hour / 24L));
  }

  public static long getDaySub(String beginDateStr, String endDateStr, String format) {
    long day = 0L;

    try {
      Date beginDate = convertStringToDate(beginDateStr, format);
      Date endDate = convertStringToDate(endDateStr, format);
      day = getDaySub(beginDate, endDate);
    } catch (Exception var7) {
      LOGGER.error("错误的日期计算", var7);
    }

    return day;
  }

  public static long getHourSub(Date beginDate, Date endDate) {
    long minute = getMinuteSub(beginDate, endDate);
    return (long)Math.round((float)(minute / 60L));
  }

  public static long getHourSub(String beginDateStr, String endDateStr, String format) {
    long hour = 0L;

    try {
      if (StringUtils.isBlank(beginDateStr) || StringUtils.isBlank(endDateStr)) {
        return 0L;
      }

      Date beginDate = convertStringToDate(beginDateStr, format);
      Date endDate = convertStringToDate(endDateStr, format);
      hour = getHourSub(beginDate, endDate);
    } catch (Exception var7) {
      LOGGER.error("错误的日期计算", var7);
    }

    return hour;
  }

  public static long getMinuteSub(Date beginDate, Date endDate) {
    long second = getSecondSub(beginDate, endDate);
    return (long)Math.round((float)(second / 60L));
  }

  public static long getMinuteSub(String beginDateStr, String endDateStr, String format) {
    long minute = 0L;

    try {
      if (StringUtils.isBlank(beginDateStr) || StringUtils.isBlank(endDateStr)) {
        return 0L;
      }

      Date beginDate = convertStringToDate(beginDateStr, format);
      Date endDate = convertStringToDate(endDateStr, format);
      minute = getMinuteSub(beginDate, endDate);
    } catch (Exception var7) {
      LOGGER.error("错误的日期计算", var7);
    }

    return minute;
  }

  public static long getSecondSub(Date beginDate, Date endDate) {
    long milliseconds = getMillisecondsSub(beginDate, endDate);
    return (long)Math.round((float)(milliseconds / 1000L));
  }

  public static long getSecondSub(String beginDateStr, String endDateStr, String format) {
    long second = 0L;

    try {
      if (StringUtils.isBlank(beginDateStr) || StringUtils.isBlank(endDateStr)) {
        return 0L;
      }

      Date beginDate = convertStringToDate(beginDateStr, format);
      Date endDate = convertStringToDate(endDateStr, format);
      second = getSecondSub(beginDate, endDate);
    } catch (Exception var7) {
      LOGGER.error("错误的日期计算", var7);
    }

    return second;
  }

  public static long getMillisecondsSub(Date beginDate, Date endDate) {
    long milliseconds = 0L;

    try {
      if (beginDate == null || endDate == null) {
        return 0L;
      }

      milliseconds = endDate.getTime() - beginDate.getTime();
    } catch (Exception var5) {
      LOGGER.error("错误的日期计算", var5);
    }

    return milliseconds;
  }

  public static long getMillisecondsSub(String beginDateStr, String endDateStr, String format) {
    long milliseconds = 0L;

    try {
      if (StringUtils.isBlank(beginDateStr) || StringUtils.isBlank(endDateStr)) {
        return 0L;
      }

      Date beginDate = convertStringToDate(beginDateStr, format);
      Date endDate = convertStringToDate(endDateStr, format);
      milliseconds = getMillisecondsSub(beginDate, endDate);
    } catch (Exception var7) {
      LOGGER.error("错误的日期计算", var7);
    }

    return milliseconds;
  }

  public static Date convertStringToDate(String date, String format) {
    SimpleDateFormat sdf = null;
    Date d = null;

    try {
      sdf = new SimpleDateFormat(format);
      sdf.setLenient(false);
      d = sdf.parse(date);
    } catch (ParseException var5) {
      LOGGER.error("错误的日期格式", var5);
    }

    return d;
  }

  public static String getNextMinute(String curDay, String dateFormat, int minute) {
    SimpleDateFormat sdf = null;
    Calendar cal = null;
    Date date = null;
    String dateStr = null;
    sdf = new SimpleDateFormat(dateFormat);
    sdf.setLenient(false);

    try {
      date = sdf.parse(curDay);
      cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(12, minute);
      date = cal.getTime();
      dateStr = sdf.format(date);
      return dateStr;
    } catch (ParseException var8) {
      LOGGER.error("错误的日期格式！", var8);
      return curDay;
    }
  }

  public static Date getNextMinute(Date date, int minute) {
    Calendar cal = null;
    cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(12, minute);
    date = cal.getTime();
    return date;
  }

  public static Date getPreMinute(Date date, int minute) {
    Calendar cal = null;
    cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(12, -minute);
    date = cal.getTime();
    return date;
  }

  public static String getPreMinute(String curDay, String dateFormat, int minute) {
    SimpleDateFormat sdf = null;
    Calendar cal = null;
    Date date = null;
    String dateStr = null;
    sdf = new SimpleDateFormat(dateFormat);
    sdf.setLenient(false);

    try {
      date = sdf.parse(curDay);
      cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(12, -minute);
      date = cal.getTime();
      dateStr = sdf.format(date);
      return dateStr;
    } catch (ParseException var8) {
      LOGGER.error("错误的日期格式！", var8);
      return curDay;
    }
  }

  public static String getWeekOfDate(Date date) {
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      int w = cal.get(7) - 1;
      if (w < 0) {
        w = 0;
      }

      return WEEKS_CN[w];
    } catch (Exception var3) {
      LOGGER.error("错误的日期转换", var3);
      return null;
    }
  }

  public static String getWeekOfDate(String dateStr, String format) {
    try {
      if (!StringUtils.isBlank(dateStr) && !StringUtils.isBlank(format)) {
        Date date = convertStringToDate(dateStr, format);
        return getWeekOfDate(date);
      } else {
        return null;
      }
    } catch (Exception var3) {
      LOGGER.error("错误的日期转换", var3);
      return null;
    }
  }

  public static Date convertDateToNewFormatDate(Date originDate, String originFormat, String targetFormat) {
    try {
      String newFormatDateStr = date2String(originDate, targetFormat);
      return convertStringToDate(newFormatDateStr, targetFormat);
    } catch (Exception var4) {
      LOGGER.error("错误的日期格式！", var4);
      return null;
    }
  }

  public static Date convertDateToNewFormatDate(String originDateStr, String originFormat, String targetFormat) {
    try {
      Date orgDate = convertStringToDate(originDateStr, originFormat);
      return convertDateToNewFormatDate(orgDate, originFormat, targetFormat);
    } catch (Exception var4) {
      LOGGER.error("错误的日期格式！", var4);
      return null;
    }
  }

  public static List<Integer> splitDate(Date date) {
    List<Integer> list = new ArrayList();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    list.add(cal.get(1));
    list.add(cal.get(2) + 1);
    list.add(cal.get(5));
    list.add(cal.get(10));
    list.add(cal.get(12));
    list.add(cal.get(13));
    return list;
  }

  public static boolean isEqualsInYMD(Date date1, Date date2) {
    Calendar c = null;

    try {
      c = Calendar.getInstance();
      c.setTime(date1);
      int year1 = c.get(1);
      int dayOfMonth1 = c.get(5);
      int dayOfYear1 = c.get(6);
      c.setTime(date2);
      int year2 = c.get(1);
      int dayOfMonth2 = c.get(5);
      int dayOfYear2 = c.get(6);
      if (year1 != year2) {
        return false;
      } else if (dayOfMonth1 != dayOfMonth2) {
        return false;
      } else {
        return dayOfYear1 == dayOfYear2;
      }
    } catch (Exception var9) {
      LOGGER.error("错误的日期比较", var9);
      return false;
    }
  }

  public static int daysBetween(Date smdate, Date bdate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    smdate = sdf.parse(sdf.format(smdate));
    bdate = sdf.parse(sdf.format(bdate));
    Calendar cal = Calendar.getInstance();
    cal.setTime(smdate);
    long time1 = cal.getTimeInMillis();
    cal.setTime(bdate);
    long time2 = cal.getTimeInMillis();
    long betweenDays = (time2 - time1) / 86400000L;
    return Integer.parseInt(String.valueOf(betweenDays));
  }

  public static int differentDays(Date date1, Date date2) {
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(date1);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(date2);
    int day1 = cal1.get(6);
    int day2 = cal2.get(6);
    int year1 = cal1.get(1);
    int year2 = cal2.get(1);
    if (year1 == year2) {
      return day2 - day1;
    } else {
      int timeDistance = 0;

      for (int i = year1; i < year2; ++i) {
        if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
          timeDistance += 365;
        } else {
          timeDistance += 366;
        }
      }

      return timeDistance + (day2 - day1);
    }
  }
}
