SECTION = "utils"
SUMMARY = "accel-read autostart"
# The license is meant for this recipe and the files it installs.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit allarch systemd

SRC_URI = " \
    file://imu-mpu6050-log.service \
    file://imu-mpu6050.sh \
"

do_install () {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/imu-mpu6050.sh ${D}/${bindir}

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/imu-mpu6050-log.service ${D}${systemd_unitdir}/system
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "imu-mpu6050-log.service"
