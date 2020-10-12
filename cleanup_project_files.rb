#!/usr/bin/env ruby
regex1 = /<nature>(net\.sf\.eclipsecs\.core\.CheckstyleNature|net\.sourceforge\.pmd\.eclipse\.plugin\.pmdNature|edu\.umd\.cs\.findbugs\.plugin\.eclipse\.findbugsNature)<\/nature>/
regex2 = /<buildCommand>\s*<name>(edu\.umd\.cs\.findbugs\.plugin\.eclipse\.findbugsBuilder|net\.sf\.eclipsecs\.core\.CheckstyleBuilder|net\.sourceforge\.pmd\.eclipse\.plugin\.pmdBuilder)<\/name>\s*<arguments>\s*<\/arguments>\s*<\/buildCommand>/
files = Dir["workspace/**/.project"].filter { |file_path| file_path =~ /.*?lab0[1234567].*/ }
files.each do |file_path|
    text = File.read(file_path)
    new_contents = text.gsub(regex1, "").gsub(regex2, "")
    puts new_contents
    File.write(file_path, new_contents)
end
