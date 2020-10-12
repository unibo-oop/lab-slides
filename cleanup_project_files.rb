#!/usr/bin/env ruby

regex1 = /<nature>(net\.sf\.eclipsecs\.core\.CheckstyleNature|net\.sourceforge\.pmd\.eclipse\.plugin\.pmdNature|edu\.umd\.cs\.findbugs\.plugin\.eclipse\.findbugsNature)<\/nature>/
regex2 = /<buildCommand>\s*<name>(edu\.umd\.cs\.findbugs\.plugin\.eclipse\.findbugsBuilder|net\.sf\.eclipsecs\.core\.CheckstyleBuilder|net\.sourceforge\.pmd\.eclipse\.plugin\.pmdBuilder)<\/name>\s*<arguments>\s*<\/arguments>\s*<\/buildCommand>/
checkstyle = 'style.xml,.checkstyle'
pmd = '.pmd,.ruleset,pmd.xml'

files = Dir['workspace/**/.project'].filter { |file_path| file_path =~ /.*?lab0[1234567].*/ }
files.each do |file_path|
  text = File.read(file_path)
  new_contents = text.gsub(regex1, '').gsub(regex2, '')
  puts new_contents
  File.write(file_path, new_contents)
end

files_to_delete = Dir["workspace/**/{#{checkstyle},#{pmd}}"].filter { |file_path| file_path =~ /.*?lab0[1234567].*/ }
files_to_delete.each do |file_path|
  puts "deleting #{file_path}"
  File.delete(file_path)
end
