using ChargeAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;


namespace ChargeAPI.Controllers
{
    public class ChargeController : ApiController
    {

        private ChargeSql repo;
        public ChargeController()
        {
            repo = new ChargeSql();
        }

        [HttpGet]
        public IHttpActionResult Get()
        {
            var data = repo.GetCharges();
            return Ok(data);
        }

        [HttpGet,Route("api/charge/cycle")]
        public IHttpActionResult GetCycle()
        {
            var data = repo.GetChargeCycle();
            return Ok(data);
        }


        [HttpGet, Route("api/charge/pattern")]
        public IHttpActionResult GetPattern()
        {
            var data = repo.getChargePattern();
            return Ok(data);
        }


        [HttpPost]
        public IHttpActionResult Post(Charge charge)
        {
            repo.AddCharge(charge);
            return Ok("posted");
        }
    }
}