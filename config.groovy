environments {
    dev {
        mobile {
            appiumUrl = 'http://47.168.247.49:4723/wd/hub'
            androidDevices = [
                    A: [name: 'LGH8153a8045f8', msisdn: '5336267898', udid: '10.254.18.86:5555']
            ]
        }
    }

    mac {
        mobile {
            iosApps = [
                    fizy: '/Users/Netas/Documents/fizy_yukler/fizy_6.9.6_RC6_prod.ipa'
            ]
            iosDevices = [
                    A: [name: 'iPhone 6 Plus', udid: 'bf444c31592e637f5403af4492501b7f6da19138', msisdn: '5336267898'],
                    B: [name: '52030347fe348427', udid: 'auto', msisdn: '5300667004']
            ]
        }
    }

    ios {
        mobile {
            appiumUrl = 'http://10.254.19.181:4723/wd/hub'
            iosApps = [
                    //fizy: '/Users/Netas/Documents/fizy_yukler/fizy_6.9.6_RC6_prod.ipa'
                    fizy: '/Users/dogancanmavuzer/Downloads/fizy_7.1.0_RC4.ipa'

            ]
            iosDevices = [
                    A: [name: 'iPhone 6 Plus', udid: 'bf444c31592e637f5403af4492501b7f6da19138', msisdn: '5380001140'],
                    B: [name: '52030347fe348427', udid: 'auto', msisdn: '5300667004']
            ]
            elementTimeout = 20
        }
    }

    android {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'tools/fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'a6a15c6e', msisdn: '5380000778'],
                    B: [name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 10
        }
    }
    iosBetul{
        mobile {
            appiumUrl = 'http://10.254.17.95:4725/wd/hub'
            iosApps = [
            ]
            iosDevices = [
                    A: [name: 'iPhone 5s', udid: 'dc029e40fab8732763a6700429697afcb9ac3b92', msisdn: '5380001145', platformVersion: '12.2']
                    //   B: [ name: 'LMX2102024e0f9', msisdn: '5300667004']
            ]
            elementTimeout = 10
            loadTimeout = 30
        }
    }


    iosfunda {
        mobile {
            appiumUrl = 'http://10.254.20.199:4723/wd/hub'
            iosApps = [
                    fizy: '/Users/dogancanmavuzer/Downloads/fizy_7.1.0_RC4.ipa'

            ]
            iosDevices = [
                    A: [name: 'iPhone 6 Plus', udid: 'bf444c31592e637f5403af4492501b7f6da19138', msisdn: '5380001140'],
            ]
            elementTimeout = 10

        }
    }

    iosbasak {
        mobile {
            appiumUrl = 'http://10.254.19.219:4725/wd/hub'
            iosApps = [
                    // fizy: '/Users/dogancanmavuzer/Downloads/fizy_7.1.0_RC4.ipa'

            ]
            iosDevices = [
                    //A: [name: 'iPhone 6 Plus', udid: 'c256bfc337b9a7e1e83ab6b669278798a2828964', msisdn: '5380001140',platformVersion: "12.2"],
                    B: [name: 'iPhone B', udid: '0ce4d8dc890ac938d8547a379043089038885214',  platformVersion: '12.3', appiumUrl: 'http://10.254.19.219:4726/wd/hub', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18500', msisdn: '5382001123']
            ]
            elementTimeout = 10

        }
    }


    androidfunda {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\fdalgic\\Documents\\fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'Android', udid: '52031dffc011a36f', msisdn: '5380001145'],
                    //   B: [ name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 10
        }
    }

    androidonur {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\onurs\\Desktop\\Otomasyon\\fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'Android', udid: 'ZY224BC2CD', msisdn: '5380001145', platformVersion:'8.0.0'],
                    //   B: [ name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 10
        }
    }

    iosOnur {
        mobile {
            appiumUrl = 'http://10.254.19.247:4726/wd/hub'
            iosApps = [
            ]
            iosDevices = [
                    A: [name: 'Automation-5', udid: 'ffb5329b3084112b80578843dfde62aa0e99cca2', msisdn: '5382001123', platformVersion: '12.2']
            ]
            elementTimeout = 10
            loadTimeout = 30
        }
    }

    iosBurak {
        mobile {
            appiumUrl = 'http://10.254.20.28:4725/wd/hub'
            iosApps = [
                 //   fizy: 'D:\\Users\\fdalgic\\Documents\\fizy.apk'
            ]
            iosDevices = [
                    A: [name:'Iphone 5 Plus', udid:'00008020-000445190E62002E', msisdn: '43253534543', platformVersion:'12.0']
                    //   B: [ name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }

    androidnatavan {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'C:\\Users\\EXT02D18797\\Desktop\\Otomasyon\\fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'HUAWEI P smart', udid: 'HBEDU18302006203', msisdn: '5315464901', platformVersion:'8.0.0', sessionOverride: 'true'],
            ]
            elementTimeout = 10
        }
    }

    iosNatavan
    {
        mobile {
            appiumUrl = 'http://10.254.17.122:4724/wd/hub'
            iosApps = [
            ]
            iosDevices = [
                    A: [name: 'Automation_6', udid: '0ce4d8dc890ac938d8547a379043089038885214', msisdn: '5382001123', platformVersion: '12.2']
            ]
            elementTimeout = 10
            loadTimeout = 30
        }
    }

    androidsoner {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\soner.kilicarslan\\Documents\\fizy_7.5.0_RC10.apk'
            ]
            androidDevices = [
                    A: [name: 'Android', udid: 'LMX2102024e0f9', msisdn: '5380001145', platformVersion: '7.1.2'],
                    //   B: [ name: 'LMX2102024e0f9', msisdn: '5300667004']
            ]
            elementTimeout = 10
        }
    }

    iosSoner {
        mobile {
            appiumUrl = 'http://10.254.19.36:4724/wd/hub'
            iosApps = [
            ]
            iosDevices = [
                    A: [name: 'iPhone 5s', udid: 'a0dbedd2fb9e34d2645e6ef443c16d53115500a3', msisdn: '5380001145', platformVersion: '12.0']
                    //   B: [ name: 'LMX2102024e0f9', msisdn: '5300667004']
            ]
            elementTimeout = 10
            loadTimeout = 30
        }
    }

    androidsezayi {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\sezayia\\applications\\fizy_7.5.0_RC10.apk'
            ]
            androidDevices = [
                    A: [name: 'ASLAN', udid: 'R38M10LG4SB', msisdn: '5380001145'],
                    //   B: [ name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 10
        }
    }

    iossezayi {
        mobile {
            appiumUrl = 'http://10.254.21.26:4724/wd/hub'
            iosApps = [
                    //fizy: '/Users/ayhan/Downloads/fizy_7.3.0_RC12.ipa'
            ]
            iosDevices = [
                    //A: [name: 'iphone X', udid: 'dc029e40fab8732763a6700429697afcb9ac3b92', msisdn: '5382001123', platformVersion: '12.2']
                    //IPHONE_5S: [ name:'Automation_8', udid:'0ce4d8dc890ac938d8547a379043089038885214', platformVersion:'12.2'],
                    IPHONE_7: [ name:'Automation_17', udid:'c256bfc337b9a7e1e83ab6b669278798a2828964', platformVersion:'12.1'],
            ]
            elementTimeout = 20
            loadTimeout = 30
            //recordVideo = true
        }
    }

    androidismail {
        mobile {
            //appiumUrl = 'http://0.0.0.0:4723/wd/hub'
            appiumUrl = 'http://47.168.247.52:4444/wd/hub'
            //appiumUrl = 'https://eu1.appium.testobject.com/wd/hub'
            /*androidApks = [
                    fizy: 'D:\\Users\\ismail.yankayis\\Documents\\fizy.apk'
            ]*/
            androidDevices = [
                    //A: [ name:'Android', udid: 'HT4BNYC05624', platformVersion: '5.0.2']
                    //A: [ name:'Android', udid: 'HBEDU18C04001607', platformVersion: '8.0.0']
                    //A: [ name:'Android', udid: '9LZ9UGLRVCIN9LBQ', platformVersion: '6.0']
                    //A: [name: 'Android', udid: 'LGH99093899b68', platformVersion: '7.0']
                    //A: [name: 'Android', udid: 'PRNJHM5SBYW8P7FM', platformVersion: '6.0']
                    A: [name: 'Android', udid: '310018c8370e33a5', platformVersion: '6.0']
                    //A: [name: 'Android', udid: 'c56bc6ff', platformVersion: '5.1.1']
                    //A: [name : 'Samsung Galaxy J7 2018', platformName: 'Android', platformVersion: '8.0.0', udid: 'Samsung_Galaxy_J7_2018_8_nt', noReset: true,
                    //                    capabilities: [testobjectApiKey: '1DCEA47E80D64633BE5DE31FBBA5E801', autoGrantPermissions: true, phoneOnly: false, automationName: 'uiautomator2', tabletOnly: false, privateDevicesOnly: false]]
            ]
            elementTimeout = 10
        }
    }


    iosayhan {
        mobile {
            appiumUrl: 'http://localhost:4723/wd/hub'
            iosApps = [

            ]
            iosDevices = [
                    A: [name: 'iPhone X', udid: '9b5bc7d2979b511236da2bf3e534786c41ff3592', msisdn: '5392135005', platformVersion: '12.2']
            ]
            elementTimeout = 10
            loadTimeout = 10
        }
    }
    androidmeltem {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\meltem.alev\\Documents\\fizy_7.3.0_Rc3.apk'
            ]
            androidDevices = [
                    //  A: [ name:'Android', udid: 'H6AKGV850550ETK', msisdn: '5380001145'], //asuszenfoneLive
                    //   A: [ name:'Android', udid: '9LZ9UGLRVCIN9LBQ', msisdn: '5380001145'],  //alcatel
                    // A: [ name:'Android', udid: 'HT4BNYC05624', msisdn: '5380001145'],  //HTC
                    A: [name: 'Android', udid: 'LGH99093899b68', msisdn: '5380001145'],  //lg
                    //A: [ name:'Android', udid: '5210a34b5b42b3f1', msisdn: '5544668925'],  //samsung

            ]
            elementTimeout = 10
        }
    }

    androidturku {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Users\\turkud\\Documents\\fizy.apk'
            ]
            androidDevices = [
                    //  A: [ name:'Android', udid: 'H6AKGV850550ETK', msisdn: '5380001145'], //asuszenfoneLive
                    //   A: [ name:'Android', udid: '9LZ9UGLRVCIN9LBQ', msisdn: '5380001145'],  //alcatel
                    // A: [ name:'Android', udid: 'HT4BNYC05624', msisdn: '5380001145', platformVersion: '5.2'],  //HTC
                     A: [name: 'Android', udid: 'LGH99093899b68', msisdn: '5380001145', platformVersion: '7.0'],  //lg
                    //A: [ name:'Android', udid: '5210a34b5b42b3f1', msisdn: '5544668925'],  //samsung
            ]
            elementTimeout = 10
        }
    }


    iosayhanjenkins {
        mobile {
            iosApps = [
                    fizy: '/Users/ayhan/Downloads/fizy_7.1.0_RC4.ipa'
            ]
            iosDevices = [
                    Guest       : [name: 'bf444c31592e637f5403af4492501b7f6da19138', udid: 'bf444c31592e637f5403af4492501b7f6da19138', msisdn: '5382001123', wdaLocalPort: '18100', appiumUrl: 'http://10.254.20.78:4724/wd/hub', guest: "yes"],
                    Non_Premium : [name: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', udid: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', msisdn: '5382001124', wdaLocalPort: '18200', appiumUrl: 'http://10.254.20.78:4725/wd/hub', nonpremiumlogin: "yes"],
                    Radio_Packet: [name: 'dc029e40fab8732763a6700429697afcb9ac3b92', udid: 'dc029e40fab8732763a6700429697afcb9ac3b92', msisdn: '5382001123', wdaLocalPort: '18300', appiumUrl: 'http://10.254.20.78:4726/wd/hub', radiologin: "yes"]
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }
    androidayhanjenkins {
        mobile {
            androidApks = [
                    // fizy: 'http://artify:Abc123def!@217.78.97.185:8081/artifactory/turkcell-test/com/ttech/tims/fizy-android/fizy_7.3.0_Rc3.apk'
            ]
            androidDevices = [
                    A: [name: 'RQ3003RUM2', udid: 'RQ3003RUM2', msisdn: '5380001145', appiumUrl: 'http://217.78.106.62:4723/wd/hub', guest: "yes"],
                    B: [name: 'de07ccdd', udid: 'de07ccdd', msisdn: '5380001146', appiumUrl: 'http://217.78.106.62:4724/wd/hub', nonpremiumlogin: "yes"],
                    C: [name: 'BH903NQK56', udid: 'BH903NQK56', msisdn: '5380001147', appiumUrl: 'http://217.78.106.62:4725/wd/hub', radiologin: "yes"],
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }

    androidayhan {
        mobile {
            //  appiumUrl = 'http://0.0.0.0:4723/wd/hub'
            androidApks = [
                    //fizy: 'D:/Users/auzundal/Documents/fizy.apk'
            ]
            androidDevices = [
                    // A: [name: '32000ae2b85fc495', udid: '32000ae2b85fc495', msisdn: '5380001145'],
                    // B: [name: 'de07ccdd', udid: 'de07ccdd', msisdn: '5380001145', appiumUrl: 'http://localhost:4723/wd/hub'],
                    A: [name: 'FFY0117912000075', udid: 'FFY0117912000075', msisdn: '5380001145', appiumUrl: 'http://localhost:4723/wd/hub'],
                    //   B: [ name: '52030347fe348427', msisdn: '5300667004']
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }
    androidgoknur {
        mobile {
            appiumUrl = 'http://0.0.0.0:4723/wd/hub'
            androidApks = [
                    //fizy: 'D:/Users/auzundal/Documents/fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'NVWR2F0392', udid: 'NVWR2F0392', msisdn: '5380001145',platformVersion: '7.0'],
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }

    iosgoknur {
        mobile {
            appiumUrl = 'http://10.254.17.122:4724/wd/hub'
            iosApps = [
                    //fizy: '/Users/ayhan/Downloads/fizy_7.3.0_RC12.ipa'
            ]
            iosDevices = [
                    A: [name: 'iphone 7', udid: 'ffb5329b3084112b80578843dfde62aa0e99cca2', msisdn: '5382001123', platformVersion: '11.4']
            ]
            elementTimeout = 20
            loadTimeout = 30
            //recordVideo = true
        }
    }

    emrahios {
        mobile {
            appiumUrl = 'http://10.254.17.122:4723/wd/hub'
            iosApps = [
                    //fizy: '/Users/ayhan/Downloads/fizy_7.3.0_RC12.ipa'
            ]
            iosDevices = [
                    A: [name: 'Automation_4', udid: 'ffb5329b3084112b80578843dfde62aa0e99cca2', msisdn: '5382001123', platformVersion: '12.2']
            ]
            elementTimeout = 20
            pageLoadTimeout = 30
            //recordVideo = true
        }
    }

    iosSahin {
        mobile {
            iosApps = [
                    //fizy: '/Users/ayhan/Downloads/fizy_7.3.0_RC12.ipa'
            ]
            iosDevices = [
                    //A: [name: 'iPhone 6', udid: '633ad5e132de3abb56085c6d1468557d1011f7f1', platformVersion: '11.4.1', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    //A: [name: 'iPhone 5', udid: 'ad18e1d7e2a42a866775e42dd30069386cd79630', platformVersion: '12.2',appiumUrl: 'http://10.254.19.247:4725/wd/hub', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    //A: [name: 'iPhone 7', udid: 'c256bfc337b9a7e1e83ab6b669278798a2828964', platformVersion: '12.3.1', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    //A: [name: 'iPhone 8 Plus', udid: 'ffb5329b3084112b80578843dfde62aa0e99cca2', platformVersion: '12.2', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    //A: [name: 'iPhone 7 Plus', udid: '00008020-0014458A14BA002E', platformVersion: '12.2', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    A: [name: 'iPhone X', udid: 'dc029e40fab8732763a6700429697afcb9ac3b92', platformVersion: '12.2', appiumUrl: 'http://10.254.19.247:4724/wd/hub', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18500', msisdn: '5382001123']
                    //A: [name: 'Automation_3', udid: 'c0cc27b6550f1237d32ace2ea9147405e203f03a', platformVersion: '12.2', appiumUrl: 'http://10.254.20.227:4724/wd/hub', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123']
                    //IPHONE_X2: [ name:'Automation_4', udid:'9b5bc7d2979b511236da2bf3e534786c41ff3592', platformVersion:'12.2', appiumUrl:'http://10.254.20.227:4725/wd/hub'],
                    //A: [name: 'iPhone 7 Plus', udid: 'da62b8424fed380a172b917dfa3ad095ef60c9c0', platformVersion: '11.4',appiumUrl: 'http://10.254.19.247:4729/wd/hub', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18700', msisdn: '5382001123']
            ]
            elementTimeout = 30
            loadTimeout = 60
            //recordVideo = true
        }
    }

    androidSahin {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Workspace\\fizy-mobil\\tools\\fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'F7AZFG04X985', msisdn: '5380000778', platformVersion: "6.0.1"]
            ]
            elementTimeout = 30
            //recordVideo = true
        }
        report {
            allure = true
            title = 'Netas - Fizy'
            logo = 'D:\\Workspace\\fizy-mobil\\tools\\fizy.png'
        }
    }

    old {
        mobile {
            appiumUrl = 'http://127.0.0.1:4723/wd/hub'
            androidApks = [
                    fizy: 'D:\\Workspace\\fizy-mobil\\tools\\fizy.apk'
            ]
            androidDevices = [
                    A: [name: 'a6a15c6e', msisdn: '5380000778', platformVersion: "6.0.1"]
            ]
            elementTimeout = 30
            //recordVideo = true
        }
        report {
            allure = true
            title = 'Netas - Fizy'
            logo = 'D:\\Workspace\\fizy-mobil\\tools\\fizy.png'
        }
    }

    test {
        mobile {
            iosApps = [
                    fizy: 'http://artify:Abc123def!@217.78.97.185:8081/artifactory/turkcell-test/com/ttech/tims/fizy-ios/fizy_7.1.0_RC4.ipa'

            ]
            iosDevices = [
                    A: [name: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', udid: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18100', msisdn: '5382001124', appiumUrl: 'http://10.254.21.111:4723/wd/hub', quest: "yes"],
                    B: [name: 'bf444c31592e637f5403af4492501b7f6da19138', udid: 'bf444c31592e637f5403af4492501b7f6da19138', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123', appiumUrl: 'http://10.254.21.111:4724/wd/hub', radiologin: "yes"],
                    C: [name: 'ba17673a69babbfb4caf35daee88e2090a7215d8', udid: 'ba17673a69babbfb4caf35daee88e2090a7215d8', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18300', msisdn: '5382001123', appiumUrl: 'http://10.254.21.111:4725/wd/hub', nonpremiumlogin: "yes"],
                    D: [name: '9b5bc7d2979b511236da2bf3e534786c41ff3592', udid: '9b5bc7d2979b511236da2bf3e534786c41ff3592', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18300', msisdn: '5382001123', appiumUrl: 'http://10.254.21.111:4726/wd/hub', premiumlogin: "yes"]

            ]
            androidApks = [
                    fizy: 'http://artify:Abc123def!@217.78.97.185:8081/artifactory/turkcell-test/com/ttech/tims/fizy-android/fizy_7.1.0_1397_prod_prod.apk'
            ]
            androidDevices = [
                    A: [name: '021c3c8620c968e8', udid: '021c3c8620c968e8', msisdn: '5380001145', appiumUrl: 'http://localhost:4723/wd/hub'],
                    B: [name: 'BH903NQK56', udid: 'BH903NQK56', msisdn: '5380001147', appiumUrl: 'http://localhost:17723/wd/hub'],
                    C: [name: '465da8fa', udid: '465da8fa', msisdn: '5380001148', appiumUrl: 'http://localhost:18723/wd/hub'],
                    D: [name: '4d004a1c9f681103', udid: '4d004a1c9f681103', msisdn: '5380001149', appiumUrl: 'http://localhost:19723/wd/hub'],
                    E: [name: '86a134ad', udid: '86a134ad', msisdn: '5380001150', appiumUrl: 'http://localhost:20723/wd/hub'],
                    F: [name: 'G6FYMNA6K7W8GUPV', udid: 'G6FYMNA6K7W8GUPV', msisdn: '5380001151', appiumUrl: 'http://localhost:21723/wd/hub'],
                    G: [name: 'SH4C5WM00915', udid: 'SH4C5WM00915', msisdn: '5380001152', appiumUrl: 'http://localhost:23723/wd/hub'],
                    H: [name: 'LGH5257ca5c0f6', udid: 'LGH5257ca5c0f6', msisdn: '5380001153', appiumUrl: 'http://localhost:24723/wd/hub'],
                    I: [name: 'MFTK7DZP49QKWGRW', udid: 'MFTK7DZP49QKWGRW', msisdn: '5380001154', appiumUrl: 'http://localhost:25723/wd/hub'],
                    J: [name: 'NZAA2A0577', udid: 'NZAA2A0577', msisdn: '5380001155', appiumUrl: 'http://localhost:26723/wd/hub'],
                    K: [name: 'c56bc6ff', udid: 'c56bc6ff', msisdn: '5380001156', appiumUrl: 'http://localhost:28723/wd/hub']
            ]
            elementTimeout = 30
            loadTimeout = 30
            recordVideo = true
        }
    }

    newdevicefarm {
        mobile {
            iosApps = [
                    fizy: 'http://artify:Abc123def!@217.78.97.185:8081/artifactory/turkcell-test/com/ttech/tims/fizy-ios/fizy_7.1.0_RC4.ipa'

            ]
            iosDevices = [
                    A: [name: 'bf444c31592e637f5403af4492501b7f6da19138', udid: 'bf444c31592e637f5403af4492501b7f6da19138', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18100', msisdn: '5382001124', appiumUrl: 'http://10.254.21.111:4723/wd/hub', quest: "yes"],
                    B: [name: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', udid: '4c48d7eae18093ab7f5733f4ab4873e17dd7c272', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18200', msisdn: '5382001123', appiumUrl: 'http://10.254.21.111:4724/wd/hub', radiologin: "yes"],
                    C: [name: 'ba17673a69babbfb4caf35daee88e2090a7215d8', udid: 'ba17673a69babbfb4caf35daee88e2090a7215d8', wdaLaunchTimeout: '999999999', wdaConnectionTimeout: '999999999', newCommandTimeout: '1000', usePrebuiltWDA: 'true', restart: 'true', useNewWDA: 'true', wdaStartupRetries: '3', wdaStartupRetryInterval: '20000', wdaLocalPort: '18300', msisdn: '5382001123', appiumUrl: 'http://10.254.21.111:4725/wd/hub', nonpremiumlogin: "yes"]

            ]
            androidApks = [
                    fizy: 'http://artify:Abc123def!@217.78.97.185:8081/artifactory/turkcell-test/com/ttech/tims/fizy-android/fizy_7.1.0_1397_prod_prod.apk'
            ]
            androidDevices = [
                    A: [name: 'auto', /*udid: 'LGM250CI89Z9OVS8RC',*/ msisdn: '5380001146', appiumUrl: 'http://47.168.247.22:4444/wd/hub'],
                    B: [name: 'auto', /*udid: 'YT55KVQGB64HQGMB' ,*/ msisdn: '5380001147', appiumUrl: 'http://47.168.247.22:4444/wd/hub'],
                    C: [name: 'auto', /*udid: '643baab1',*/ msisdn: '5380001148', appiumUrl: 'http://47.168.247.22:4444/wd/hub']
            ]
            elementTimeout = 30
            loadTimeout = 30
        }
    }

    prod {
    }

    jenkins {
        mobile {
            appiumUrl = System.getProperty('defaultAppiumUrl', 'http://127.0.0.1:4723/wd/hub')

            androidAppProperties = [
                    fizy: 'androidAppPath'
            ]

            iosAppProperties = [
                    fizy: 'iosAppPath'
            ]

            androidDeviceProperties = [
                    A: [name: 'Android_A_name', udid: 'Android_A_udid', msisdn: 'Android_A_msisdn', appiumUrl: 'Android_A_appiumURL']
            ]

            iosDeviceProperties = [
                    A: [name: 'iOS_A_name', udid: 'iOS_A_udid', msisdn: 'iOS_A_msisdn', appiumUrl: 'iOS_A_appiumURL']
            ]

            if (System.getProperty("androidApks")) {
                androidApks = Eval.me(System.getProperty("androidApks"))
            } else {
                androidApks = []
                for (property in androidAppProperties) {
                    if (System.getProperty(property.value)) {
                        def map = [:]
                        map[property.key] = System.getProperty(property.value)
                        androidApks.add(map)
                    }
                }
            }

            if (System.getProperty("iosApps")) {
                iosApps = Eval.me(System.getProperty("iosApps"))
            } else {
                iosApps = []
                for (property in iosAppProperties) {
                    if (System.getProperty(property.value)) {
                        def map = [:]
                        map[property.key] = System.getProperty(property.value)
                        iosApps.add(map)
                    }
                }
            }

            if (System.getProperty("androidDevices")) {
                androidDevices = Eval.me(System.getProperty("androidDevices"))
            } else {
                androidDevices = [:]
                for (property in androidDeviceProperties) {
                    def map = [:]
                    for (parameter in property.value) {
                        map[parameter.key] = System.getProperty(parameter.value)
                    }
                    androidDevices[property.key] = map
                }
            }

            if (System.getProperty("iosDevices")) {
                iosDevices = Eval.me(System.getProperty("iosDevices"))
            } else {
                iosDevices = [:]
                for (property in iosDeviceProperties) {
                    def map = [:]
                    for (parameter in property.value) {
                        map[parameter.key] = System.getProperty(parameter.value)
                    }
                }
            }

            if (System.getProperty("elementTimeout")) {
                elementTimeout = System.getProperty("elementTimeout") as Integer
            }

            if (System.getProperty("loadTimeout")) {
                loadTimeout = System.getProperty("loadTimeout") as Integer
            }
        }
    }

    jenkins_static {
        mobile {
            appiumUrl = 'http://47.168.247.22:4444/wd/hub'

            shareTags = "@whatsapp or @bip or @instagram or @facebook or @messenger or @messaging or @twitter"

            androidDevices = [
                    A: [name: 'General Mobile GM8', udid: '0123456789ABCDEF', reservedFor: shareTags],
                    B: [name: 'Turkcell T80', udid: '10c78562', reservedFor: "@nonPremiumUser and not(@downloadPackage) and not(${shareTags})"],
                    C: [name: 'Turkcell T70', udid: '297089d0', reservedFor: "@airplanemode and not(${shareTags})"],
                    D: [name: 'Lenovo K6 Note', udid: '465da8fa', reservedFor: "@nonPremiumUser and not(@downloadPackage) and not(${shareTags})"],
                    E: [name: 'Samsung S4', udid: '4d004a1c9f681103', reservedFor: "@nonPremiumUser and not(@downloadPackage) and not(${shareTags})"],
                    F: [name: 'Turkcell T50', udid: '59106d00', platformVersion: '4.4.2', reservedFor: "@nonPremiumUser and not(@downloadPackage) and not(${shareTags})"],
                    G: [name: 'Samsung S5 Mini', udid: '86a134ad', reservedFor: "@nonPremiumUser and @downloadPackage and not(${shareTags})"],
                    H: [name: 'Turkcell T60', udid: '8d18b8dc', reservedFor: "@nonPremiumUser and @downloadPackage and not(${shareTags})"],
                    I: [name: 'Sony Xperia X', udid: 'BH903NQK56', reservedFor: "@nonPremiumUser and @downloadPackage and not(${shareTags})"],
                    J: [name: 'Alcatel Idol 5', udid: 'G6FYMNA6K7W8GUPV', reservedFor: "@guestUser and not(${shareTags})"],
                    K: [name: 'HTC One M8', udid: 'HT427WM00531', reservedFor: "@guestUser and not(${shareTags})"],
                    L: [name: 'HTC One Mini 2', udid: 'HT43EWR00285', platformVersion: '4.4.2', reservedFor: "@radioUser and not(${shareTags})"],
                    M: [name: 'LG G4', udid: 'LGH5257ca5c0f6', reservedFor: "@radioUser and not(${shareTags})"],
                    N: [name: 'Casper VIA M4', udid: 'MFTK7DZP49QKWGRW', reservedFor: "@nonPremiumUser and not(@downloadPackage) and not(${shareTags})"],
                    O: [name: 'Moto G 5S Plus', udid: 'NZAA2A0577', reservedFor: "@nonPremiumUser and @downloadPackage and not(${shareTags})"],
                    P: [name: 'Casper VIA A1', udid: 'PRNJHM5SBYW8P7FM', reservedFor: "@radioUser and not(${shareTags})"],
                    R: [name: 'Samsung S7', udid: 'c56bc6ff', reservedFor: "@airplanemode and not(${shareTags})"],
            ]

            execution.parallel {
                featureTags "@android and @guestUser", parallel: 2
                featureTags "@android and @nonPremiumUser and @downloadPackage", parallel: 3
                featureTags "@android and @nonPremiumUser and not(@downloadPackage)", parallel: 5
                featureTags "@android and @radioUser", parallel: 2
            }

            elementTimeout = 60
            loadTimeout = 60
            //recordVideo = true
        }

    }

    iosMne {
        mobile {
            appiumUrl = 'http://10.254.17.122:4727/wd/hub'
            iosApps = [
                     //ip address of remote macbook
            ]
            iosDevices = [
                    A: [name: 'Automation_10', udid: '00008020-000445190E62002E', msisdn: '5392135005', platformVersion: '12.2']
            ]
            elementTimeout = 20
            loadTimeout = 10
        }
    }



    // iPhone 7 Plus da62b8424fed380a172b917dfa3ad095ef60c9c0  pv: 11.4
    // iPhone 8 Plus ffb5329b3084112b80578843dfde62aa0e99cca2      12.2
    // iPhone 5 s    0ce4d8dc890ac938d8547a379043089038885214      12.3
    // 6             633ad5e132de3abb56085c6d1468557d1011f7f1      11.4
    // XS            00008020-000445190E62002E                     12.0
    // 7             dc029e40fab8732763a6700429697afcb9ac3b92      11.4
    //X              9b5bc7d2979b511236da2bf3e534786c41ff3592      12.3
}
