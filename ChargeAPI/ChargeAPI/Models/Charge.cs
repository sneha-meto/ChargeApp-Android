using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChargeAPI.Models
{
    public class Charge
    {
        public Charge(String time, int batteryLevel, bool isCharging)
        {
            Time =  time;
            BatteryLevel = batteryLevel;
            IsCharging = isCharging;

        }

        public string Time { get; set; }
        public int BatteryLevel { get; set; }
        public bool IsCharging { get; set; }
    }
}