# Copyright (C) 2013-2015 Freescale Semiconductor
# Copyright (C) 2016 sitec systems GmbH

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LOCALVERSION = "-1.0.0-RC1"
PR = "r12"

SRCBRANCH = "imx_3.14.28_1.0.0_ga"
SRCREV = "91cf351a2afc17ac4a260e4d2ad1e32d00925a1b"
KERNEL_SRC ?= "git://git.freescale.com/imx/linux-2.6-imx.git;protocol=git"

SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRC_URI += "file://0001-Makefile-Add-sitec-label-to-EXTRAVERSION.patch"
SRC_URI += "file://0002-Add-initial-support-for-sitec-devices.patch"
SRC_URI += "file://0003-Initial-commit-of-include-file.patch"
SRC_URI += "file://0004-Minimize-device-tree-for-the-S2.patch"
SRC_URI += "file://0005-Minimize-device-tree-for-S-Core-eval-board.patch"
SRC_URI += "file://0006-S2-Add-settings-for-S2.patch"
SRC_URI += "file://0007-S2-Add-gpio_setup-for-the-S2.patch"
SRC_URI += "file://0008-S-Core-Add-support-for-CAN-pins-to-S-Core-Eval-dts.patch"
SRC_URI += "file://0009-S-Core-Add-CAN-gpio-initialisation-at-startup.patch"
SRC_URI += "file://0010-s2-Add-LED-blink-at-boot-up.patch"
SRC_URI += "file://0011-S-Core-Add-support-for-USB-Interfaces.patch"
SRC_URI += "file://0012-S2-Change-state-of-the-termination-resistor.patch"
SRC_URI += "file://0013-S2-Add-reboot-over-KILL_MAIN_PWR-GPIO.patch"
SRC_URI += "file://0014-FlexCAN-Replace-usleep_range-with-udelay.patch"
SRC_URI += "file://0015-tty-imx-Fix-dma-buffer-overflow-for-low-latency.patch"
SRC_URI += "file://0016-S2-Change-the-handling-of-the-handshake-control-line.patch"
SRC_URI += "file://0017-S2-Export-GPIOs-for-RTS-and-CTS-lines-on-UART6.patch"
SRC_URI += "file://0018-S2-Remove-init-of-usdhc3.patch"
SRC_URI += "file://0019-gpio-wakeup-Initial-commit.patch"
SRC_URI += "file://0020-arm-dts-Remove-device-specific-devicetrees.patch"
SRC_URI += "file://0021-mach-imx6sx-Change-the-states-of-UART6-RTS-and-CTS.patch"
SRC_URI += "file://0022-mach-imx6sx-Change-state-of-gnss_pwr_e.patch"
SRC_URI += "file://0023-mach-imx6sx-Add-GPIO-init-for-wifi-GPIOs.patch"
SRC_URI += "file://defconfig"
SRC_URI += "file://9000-S-Core-Initial-commit-of-specific-score-dts.patch"

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6)"
