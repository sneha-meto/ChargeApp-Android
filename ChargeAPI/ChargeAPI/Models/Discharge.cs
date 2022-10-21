using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChargeAPI.Models
{
    public class Discharge
    {
        public Discharge(int hour, int level, TimeSpan dischargeTime)
        {
            Hour = hour;
            Level = level;
            DischargeTime = dischargeTime;
        }

        public int Hour { get; set; }
        public int Level { get; set; }
        public TimeSpan DischargeTime { get; set; }

        


    }
}