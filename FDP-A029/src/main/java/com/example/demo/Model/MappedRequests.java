package com.example.demo.Model;

public class MappedRequests {
		 String donationId;
		 String requestId;
		 String logisticId;
		 String status;
		public String getDonationId() {
			return donationId;
		}
		public void setDonationId(String donationId) {
			this.donationId = donationId;
		}
		public String getRequestId() {
			return requestId;
		}
		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}
		public String getLogisticId() {
			return logisticId;
		}
		public void setLogisticId(String logisticId) {
			this.logisticId = logisticId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "MappedRequests [donationId=" + donationId + ", requestId=" + requestId + ", logisticId="
					+ logisticId + ", status=" + status + "]";
		}
		
}

