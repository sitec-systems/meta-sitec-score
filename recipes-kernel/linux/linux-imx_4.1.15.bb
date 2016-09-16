# Copyright (C) 2013-2015 Freescale Semiconductor
# Copyright (C) 2016 sitec systems GmbH

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LOCALVERSION = "-1.0.0"
PR = "r4"

SRCBRANCH = "imx_4.1.15_1.0.0_ga"
SRCREV = "a4d2a08f3bfc57ff5d7d1307fb23f52f1e681aca"
KERNEL_SRC ?= "git://git.freescale.com/imx/linux-2.6-imx.git;protocol=git"

SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRC_URI += "file://gcc6_integrate_fix.patch"
SRC_URI += "file://bcmhd_gcc6_indent_warning_error_fix.patch"
SRC_URI += "file://gpu-viv_gcc6_indent_warning_error_fix.patch"
SRC_URI += "file://1000-Makefile-Add-sitec-label-to-version.patch"
SRC_URI += "file://1001-mach-imx6sx-Add-gpio-initialisation.patch"
SRC_URI += "file://1002-gpio-wakeup-Add-driver-for-wakeup-over-gpio.patch"
SRC_URI += "file://1003-tty-imx-Fix-dma-buffer-overflow-for-low-latency.patch"
SRC_URI += "file://1004-dts-imx6sx-score-Initial-commit.patch"
SRC_URI += "file://1005-misc-tja1145-Initial-commit.patch"
SRC_URI += "file://1006-dts-imx6sx-score-Add-config-for-uart2-and-uart6.patch"
SRC_URI += "file://1007-arm-mach-imx6sx-Add-GPIOs-for-init-routine.patch"
SRC_URI += "file://1008-misc-tja1145-Fix-read-and-write-access.patch"
SRC_URI += "file://1009-mach-imx6sx-Add-init-for-native-and-expander-gpios.patch"
SRC_URI += "file://1010-mach-imx6sx-Change-direction-of-reference-clk.patch"
SRC_URI += "file://1011-mach-imx6sx-Add-init-for-lan-power-enable-pin.patch"
SRC_URI += "file://1012-imx6sx-pinfunc-Add-SION-bit-for-ENET2-Ref-Clock.patch"
SRC_URI += "file://1013-imx6sx-score.dtsi-Change-the-ref-clk.patch"
SRC_URI += "file://1014-clk-imx6sx-Change-clk-root-for-ENET.patch"

SRC_URI += "file://defconfig"

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6)"
